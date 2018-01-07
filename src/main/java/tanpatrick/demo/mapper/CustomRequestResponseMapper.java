package tanpatrick.demo.mapper;

import org.apache.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collections;

/**
 * @author Patrick Tan <tanpatrickjoseph@gmail.com>
 */
public class CustomRequestResponseMapper extends RequestResponseBodyMethodProcessor {

    private static final Logger LOGGER = Logger.getLogger(CustomRequestResponseMapper.class);

    public CustomRequestResponseMapper() {
        super(Collections.<HttpMessageConverter<?>>singletonList(new MappingJackson2HttpMessageConverter()));
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(MyMapper.class);
    }

    @Override
    protected <T> Object readWithMessageConverters(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType) throws IOException, HttpMediaTypeNotSupportedException, HttpMessageNotReadableException {
        MyMapper myMapperAnnotation = parameter.getParameterAnnotation(MyMapper.class);

        if (myMapperAnnotation != null) {
            return super.readWithMessageConverters(inputMessage, parameter, myMapperAnnotation.value());
        }

        return super.readWithMessageConverters(inputMessage, parameter, targetType);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        MyMapper myMapper = parameter.getParameterAnnotation(MyMapper.class);

        Object value = super.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
        Object mapper = Mappers.getMapper(myMapper.mapper());

        for (Method method : mapper.getClass().getMethods()) {
            if (myMapper.method().equals(method.getName())) {
                return method.invoke(mapper, value);
            }
        }

        return null;
    }

}

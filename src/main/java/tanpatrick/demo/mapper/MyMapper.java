package tanpatrick.demo.mapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Patrick Tan <tanpatrickjoseph@gmail.com>
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyMapper {

    Class<?> value();

    Class<?> mapper() default void.class;

    String method() default "";

}

package tanpatrick.demo.mapper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tanpatrick.demo.mapper.dto.PersonDto;
import tanpatrick.demo.mapper.mapper.PersonMapper;
import tanpatrick.demo.mapper.model.Person;

import java.util.List;

/**
 * @author Patrick Tan <tanpatrickjoseph@gmail.com>
 */
@SpringBootApplication
@RestController
@RequestMapping("/api/person")
public class Application extends WebMvcConfigurerAdapter {

    private static final Logger LOGGER = Logger.getLogger(Application.class);

    @Autowired
    private PersonMapper personMapper;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CustomRequestResponseMapper());
        super.addArgumentResolvers(argumentResolvers);
    }

    @PostMapping("/submit")
    public ResponseEntity<PersonDto> submit(@MyMapper(value = PersonDto.class, mapper = PersonMapper.class, method = "toModel") Person person) {
        Person personFromDB = new Person();
        personFromDB.setFirstName("patrick");
        personFromDB.setLastName("tan");
        return ResponseEntity.ok(personMapper.toDto(personMapper.merge(person, personFromDB)));
    }

}

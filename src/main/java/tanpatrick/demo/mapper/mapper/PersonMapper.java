package tanpatrick.demo.mapper.mapper;

import org.mapstruct.*;
import tanpatrick.demo.mapper.dto.PersonDto;
import tanpatrick.demo.mapper.model.Person;

/**
 * @author Patrick Tan <tanpatrickjoseph@gmail.com>
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mappings({
        @Mapping(source = "city", target = "address.city"),
        @Mapping(source = "country", target = "address.country")
    })
    Person toModel(PersonDto personDto);

    @Mappings({})
    Person merge(Person person, @MappingTarget Person newPerson);

    @InheritInverseConfiguration(name = "toModel")
    PersonDto toDto(Person person);
}

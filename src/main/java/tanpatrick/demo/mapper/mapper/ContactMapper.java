package tanpatrick.demo.mapper.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import tanpatrick.demo.mapper.dto.ContactDto;
import tanpatrick.demo.mapper.model.Contact;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    @Mappings({
        @Mapping(source = "contactNo", target = "phoneNo")
    })
    Contact toModel(ContactDto contactDto);

    @InheritInverseConfiguration
    ContactDto toDto(Contact contact);

}

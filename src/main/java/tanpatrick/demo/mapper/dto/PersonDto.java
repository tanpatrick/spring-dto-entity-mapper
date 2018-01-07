package tanpatrick.demo.mapper.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Patrick Tan <tanpatrickjoseph@gmail.com>
 */
@Getter
@Setter
@ToString
public class PersonDto {

    private Long personId;
    private String lastName;
    private String firstName;
    private String city;
    private String country;
    private Set<ContactDto> contactDtos = new HashSet<>();

}

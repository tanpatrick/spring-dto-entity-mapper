package tanpatrick.demo.mapper.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

}

package tanpatrick.demo.mapper.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Patrick Tan <tanpatrickjoseph@gmail.com>
 */
@Getter
@Setter
@ToString
public class Person {

    private Long personId;
    private String lastName;
    private String firstName;
    private Address address;

}

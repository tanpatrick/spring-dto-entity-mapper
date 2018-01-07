package tanpatrick.demo.mapper.model;

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
public class Person {

    private Long personId;
    private String lastName;
    private String firstName;
    private Address address;
    private Set<Contact> contacts = new HashSet<>();

}

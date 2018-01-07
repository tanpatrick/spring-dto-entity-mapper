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
public class Address {

    private Long addressId;
    private String city;
    private String country;

}

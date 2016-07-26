package matrix;

import matrix.annotation.InjectRandomInt;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by rpadalka on 10.07.16.
 */
@Component("pill")
@Scope("prototype")
public class Pill {

    @InjectRandomInt(min = 1, max = 99)
    private int randomInt;
    private String colour;

    public Pill(String colour) {
        this.colour = colour;
    }

    public Pill() {
        this.colour = "red";
    }

    public String getColour() {
        return colour;
    }

    public int getRandomInt() {
        return randomInt;
    }
}

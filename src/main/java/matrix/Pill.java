package matrix;

import matrix.annotation.InjectRandomInt;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by rpadalka on 10.07.16.
 */
@Component
@Scope("periodical")
public class Pill {

    @InjectRandomInt(min = 1, max = 99)
    private int randomInt;
    private PillColour colour;

    public Pill() {
        Random random = new Random();
        this.colour = PillColour.getColourById(random.nextInt(6));
    }

    public PillColour getColour() {
        return colour;
    }

    public int getRandomInt() {
        return randomInt;
    }
}

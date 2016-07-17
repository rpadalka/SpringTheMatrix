package matrix;

import matrix.annotation.InjectRandomInt;

/**
 * Created by rpadalka on 10.07.16.
 */
public class Pill {

    @InjectRandomInt(min = 1, max = 99)
    private int randomInt;
    private String colour;

    public Pill(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public int getRandomInt() {
        return randomInt;
    }
}

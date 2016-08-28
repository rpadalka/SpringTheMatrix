package matrix;

/**
 * Created by rpadalka on 28.08.16.
 */
public enum PillColour {
    red(1),
    orange(2),
    yellow(3),
    green(4),
    blue(5),
    purple(6),
    unknown(0);

    private int identifier;

    PillColour(int id) {
        this.identifier = id;
    }

    public static PillColour getColourById(int id) {
        for (PillColour pillColour : PillColour.values()) {
            if (pillColour.identifier == id) {
                return pillColour;
            }
        }

        return unknown;
    }
}

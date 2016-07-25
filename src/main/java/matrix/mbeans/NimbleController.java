package matrix.mbeans;

/**
 * Created by rpadalka on 25.7.16.
 */
public class NimbleController implements NimbleControllerMBean {

    private boolean shooting = false;

    public boolean isShooting() {
        return shooting;
    }

    @Override
    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }
}

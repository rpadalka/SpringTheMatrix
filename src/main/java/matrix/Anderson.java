package matrix;

/**
 * Created by rpadalka on 10.07.16.
 */
public class Anderson implements DrugDealer, Elected {

    private Pill pill;

    public Pill getPill() {
        return pill;
    }

    public void setPill(Pill pill) {
        this.pill = pill;
    }

    @Override
    public void doSomething() {
        System.out.println("Mr. Anderson do something!");
    }
}

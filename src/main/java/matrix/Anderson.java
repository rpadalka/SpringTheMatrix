package matrix;

/**
 * Created by rpadalka on 10.07.16.
 */
public class Anderson implements DrugDealer, Elected, Human {

    private String name;
    private Pill pill;

    @Override
    public Pill getPill() {
        return pill;
    }

    @Override
    public void setPill(Pill pill) {
        this.pill = pill;
    }

    @Override
    public void doSomething() {
        System.out.println(String.format("%s do something!", name));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

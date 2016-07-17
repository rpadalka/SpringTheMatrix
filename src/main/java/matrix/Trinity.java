package matrix;

/**
 * Created by rpadalka on 10.07.16.
 */
public class Trinity implements DrugDealer, Human {

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

    public void trustInElected() {
        System.out.println(String.format("%s trust in Elected!", name));
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

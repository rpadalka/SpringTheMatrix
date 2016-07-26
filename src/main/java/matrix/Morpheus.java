package matrix;

/**
 * Created by rpadalka on 10.07.16.
 */
public abstract class Morpheus implements DrugDealer, Human {

    private String name;
    private Pill pill;

    public Morpheus() {
        this.name = "Morpheus";
    }

    @Override
    public Pill getPill() {
        return makePills();
    }

    @Override
    public void setPill(Pill pill) {
        this.pill = pill;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    protected abstract Pill makePills();
}

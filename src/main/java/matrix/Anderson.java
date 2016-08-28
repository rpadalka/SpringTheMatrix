package matrix;

import matrix.annotation.Nimble;
import matrix.annotation.PostProxy;

/**
 * Created by rpadalka on 10.07.16.
 */
@Nimble(newImpl = Neo.class)
public class Anderson implements DrugDealer, ChosenOne, Human {

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
    @PostProxy
    public void doesSomething() {
        System.out.println(String.format("%s does something!\n", name));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private static class ChosenOneHolder {
        static Anderson instance = new Anderson();
    }

    public static Anderson getChosenOne() {
        return ChosenOneHolder.instance;
    }
}

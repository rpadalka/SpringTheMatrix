package matrix;

import org.springframework.stereotype.Component;

/**
 * Created by rpadalka on 10.07.16.
 */
@Component
public class Trinity implements DrugDealer, Human {

    private String name;
    private Pill pill;

    public Trinity() {
        this.name = "Trinity";
    }

    @Override
    public Pill getPill() {
        return pill;
    }

    @Override
    public void setPill(Pill pill) {
        this.pill = pill;
    }

    public void trustInChosenOne() {
        System.out.println(String.format("%s trust in ChosenOne!", name));
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

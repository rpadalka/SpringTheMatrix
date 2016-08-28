package matrix;

import matrix.annotation.PostProxy;

/**
 * Created by rpadalka on 28.08.16.
 */

public class Neo extends Anderson implements ChosenOne {

    @Override
    @PostProxy
    public void doesSomething() {
        System.out.println(String.format("%s flies!\n", getName()));
    }
}

package matrix.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by rpadalka on 17.07.16.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {
    int min();
    int max();
}

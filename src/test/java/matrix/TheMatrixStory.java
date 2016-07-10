package matrix;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by rpadalka on 10.07.16.
 */

public class TheMatrixStory extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TheMatrixStory(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TheMatrixStory.class );
    }

    public void testApp() throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("wachowskis-film.xml");
        applicationContext.getBean(Elected.class).doSomething();
    }
}

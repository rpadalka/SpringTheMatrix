package matrix;

import context.PropertyFileApplicationContext;
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
        Morpheus morpheus = applicationContext.getBean("morpheus", Morpheus.class);
        Trinity trinity = applicationContext.getBean("trinity", Trinity.class);
        // Тринити выходит из матрицы
        trinity.setPill(morpheus.getPill());
        // Нео выходит из матрицы
        PropertyFileApplicationContext propertyContext = new PropertyFileApplicationContext("elected.properties");
        propertyContext.getBean(DrugDealer.class).setPill(morpheus.getPill());

        System.out.println(String.format("Trinity ate a %s pill.", trinity.getPill().getColour()));
        System.out.println(String.format("Mr.Anderson ate a %s pill.", propertyContext.getBean(DrugDealer.class).getPill().getColour()));

        // Нео делает что-то и Тринити верит в избранного
        propertyContext.getBean(Elected.class).doSomething();
    }
}

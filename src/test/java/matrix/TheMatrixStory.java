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
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("XmlConfigApplicationContext.xml");

        Morpheus morpheus = xmlApplicationContext.getBean("morpheus", Morpheus.class);
        Trinity trinity = xmlApplicationContext.getBean("trinity", Trinity.class);
        // Тринити выходит из матрицы
        trinity.setPill(morpheus.getPill());
        // Нео выходит из матрицы
        DrugDealer neo = xmlApplicationContext.getBean("neo", DrugDealer.class);
        neo.setPill(morpheus.getPill());

        // Сравниваем, разные ли таблетки ели Тринити и Нео
        System.out.println("\nPills are equals? " + (trinity.getPill().getRandomInt() == neo.getPill().getRandomInt()) + "\n");

        System.out.println(String.format("Trinity ate a %s pill.", trinity.getPill().getColour().name()));
        System.out.println(String.format("Mr.Anderson ate a %s pill.", neo.getPill().getColour().name()) + "\n");

        while (true) {
            Thread.sleep(1000);
            System.out.println("Morpheus has a " + morpheus.getPill().getColour().name() + " pill.");
        }
    }
}

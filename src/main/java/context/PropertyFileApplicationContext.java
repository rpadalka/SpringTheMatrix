package context;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by rpadalka on 15.7.16.
 */
public class PropertyFileApplicationContext extends GenericApplicationContext {
    public PropertyFileApplicationContext(String fileName) {
        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(this);
        beanDefinitionReader.loadBeanDefinitions(fileName);
        refresh();
    }
}

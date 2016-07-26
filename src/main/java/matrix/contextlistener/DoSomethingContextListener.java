package matrix.contextlistener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by rpadalka on 26.07.16.
 */
@Component
public class DoSomethingContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
            String originalClassName = beanDefinition.getBeanClassName();

            try {
                Class<?> originalClass = Class.forName(originalClassName);
                Method[] originalClassMethods = originalClass.getMethods();

                for (Method originalClassMethod : originalClassMethods) {
                    /*if (originalClassMethod.isAnnotationPresent()) {
                        Object bean = applicationContext.getBean(beanDefinitionName);
                        Method beanMethod = bean.getClass().getMethod(originalClassMethod.getName(), originalClassMethod.getParameterTypes());
                    }*/
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

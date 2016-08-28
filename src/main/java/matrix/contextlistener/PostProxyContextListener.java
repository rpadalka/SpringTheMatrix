package matrix.contextlistener;

import matrix.annotation.PostProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by rpadalka on 26.07.16.
 */
@Component
public class PostProxyContextListener implements ApplicationListener<ContextRefreshedEvent> {

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
                    if (originalClassMethod.isAnnotationPresent(PostProxy.class)) {
                        System.out.println("\nPostProxy annotation. ContextRefreshedEvent.");
                        Object bean = applicationContext.getBean(beanDefinitionName);
                        Method beanMethod = bean.getClass().getMethod(originalClassMethod.getName(), originalClassMethod.getParameterTypes());
                        beanMethod.invoke(bean);
                    }
                }
            } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

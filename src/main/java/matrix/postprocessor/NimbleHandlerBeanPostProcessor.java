package matrix.postprocessor;

import matrix.annotation.Nimble;
import matrix.mbeans.NimbleController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rpadalka on 25.7.16.
 */
public class NimbleHandlerBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class> map = new HashMap<>();
    private NimbleController controller = new NimbleController();

    public NimbleHandlerBeanPostProcessor() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        server.registerMBean(controller, new ObjectName("shooting", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();

        if (beanClass.isAnnotationPresent(Nimble.class)) {
            map.put(beanName, beanClass);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);

        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
                if (controller.isShooting()) {
                    System.out.println("++++++ BEGIN SHOOTING ++++++");
                    Object returnValue = method.invoke(bean, args);
                    System.out.println("Miss on " + beanName);
                    System.out.println("++++++ END SHOOTING ++++++");

                    return returnValue;
                } else {
                    return method.invoke(bean, args);
                }
            });
        }

        return bean;
    }
}

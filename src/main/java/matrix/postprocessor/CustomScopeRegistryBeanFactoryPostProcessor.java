package matrix.postprocessor;

import matrix.scope.PeriodicalScope;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Created by rpadalka on 26.7.16.
 */
@Component
public class CustomScopeRegistryBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        configurableListableBeanFactory.registerScope("periodical", new PeriodicalScope());
    }
}

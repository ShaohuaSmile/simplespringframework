package shaohua.study.simplespringframework.factory;

import shaohua.study.simplespringframework.beans.BeanDefinition;
import shaohua.study.simplespringframework.beans.PropertyValue;
import shaohua.study.simplespringframework.beans.PropertyValues;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/14 9:39
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    /** Map of bean definition objects, keyed by bean name */
    protected Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,BeanDefinition>();

    /**
     * 功能描述: 向容器获取bean，为空则创建
     *
     * @author Liush
     * @date 2017/11/14
     */
    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition  = beanDefinitionMap.get(name);
        if(beanDefinition == null){
            throw new RuntimeException("No such bean definition:" + name);
        }
        Object bean = beanDefinition.getBean();
        if(bean == null){
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
    
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }
}

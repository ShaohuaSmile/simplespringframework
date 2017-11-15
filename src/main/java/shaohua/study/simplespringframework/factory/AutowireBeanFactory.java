package shaohua.study.simplespringframework.factory;

import shaohua.study.simplespringframework.beans.BeanDefinition;
import shaohua.study.simplespringframework.beans.BeanReference;
import shaohua.study.simplespringframework.beans.PropertyValue;
import shaohua.study.simplespringframework.beans.PropertyValues;

import java.lang.reflect.Field;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/14 10:06
 */
public class AutowireBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
        String className = beanDefinition.getClassName();
        Class clazz = Class.forName(className,true,this.getClass().getClassLoader());
        Object bean = clazz.newInstance();
        beanDefinition.setBean(bean);
        applyPropertyValues(beanDefinition);
        return bean;
    }

    /**
     * 功能描述: bean属性赋值
     *
     * @author Liush
     * @date 2017/11/14
     */
    private void applyPropertyValues(BeanDefinition beanDefinition) throws Exception {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        if(propertyValues != null){
            Object bean = beanDefinition.getBean();
            Class clazz = bean.getClass();
            for(PropertyValue pv : propertyValues.getProperties()){
                String name = pv.getName();
                Object value = pv.getValue();
                try {
                    Field field = clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    if(value instanceof BeanReference){
                        BeanReference beanReference = (BeanReference) value;
                        value = getBean(beanReference.getName());
                    }
                    field.set(bean,value);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

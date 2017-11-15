package shaohua.study.simplespringframework.beans;

/**
 * 功能描述: bean定义
 *
 * @author Liush
 * @date 2017/11/13 18:06
 */
public interface BeanDefinition {
    Object getBean();
    void setBean(Object bean);
    String getName();
    String getClassName();
    Class getBeanClass();
    PropertyValues getPropertyValues();
}

package shaohua.study.simplespringframework.beans;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/14 15:36
 */
public class AutowireBeanDefinition implements BeanDefinition{
    private Object bean;

    private String name;

    private String className;

    private Class beanClass;
    private PropertyValues propertyValues;
    @Override
    public Object getBean() {
        return this.bean;
    }

    @Override
    public void setBean(Object bean) {
        this.bean = bean;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getClassName() {
        return this.className;
    }

    @Override
    public Class getBeanClass() {
        return this.beanClass;
    }

    @Override
    public PropertyValues getPropertyValues() {
        return propertyValues == null ? propertyValues = new PropertyValues():propertyValues;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}

package shaohua.study.simplespringframework.context;

import shaohua.study.simplespringframework.factory.AbstractBeanFactory;

import java.io.IOException;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/15 9:34
 */
public abstract class AbstractApplicationContext implements ApplicationContext{
    protected AbstractBeanFactory beanFactory;

    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }

    public abstract void refresh() throws IOException, ClassNotFoundException;
}

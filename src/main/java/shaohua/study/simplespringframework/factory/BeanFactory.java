package shaohua.study.simplespringframework.factory;

import shaohua.study.simplespringframework.beans.BeanDefinition;

/**
 * 功能描述: bean工厂，提供注册、获取bean
 *
 * @author Liush
 * @date 2017/11/14 9:36
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;
}

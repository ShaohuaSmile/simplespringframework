package shaohua.study.simplespringframework.reader;

import shaohua.study.simplespringframework.beans.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/14 11:58
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    protected Map<String,BeanDefinition> registry = new HashMap<String, BeanDefinition>();

    public Map<String,BeanDefinition> getRegistry(){
        return registry;
    }

}

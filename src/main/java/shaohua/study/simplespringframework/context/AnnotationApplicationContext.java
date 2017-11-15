package shaohua.study.simplespringframework.context;

import shaohua.study.simplespringframework.beans.BeanDefinition;
import shaohua.study.simplespringframework.factory.AutowireBeanFactory;
import shaohua.study.simplespringframework.reader.AnnotationBeanDefinitionReader;
import shaohua.study.simplespringframework.reader.BeanDefinitionReader;

import java.io.IOException;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/15 9:39
 */
public class AnnotationApplicationContext extends AbstractApplicationContext {

    private final String[] scanPackages;

    public AnnotationApplicationContext(String... scanPackages) throws IOException, ClassNotFoundException {
        this.scanPackages = scanPackages;
        this.beanFactory = new AutowireBeanFactory();
        refresh();
    }

    @Override
    public void refresh() throws IOException, ClassNotFoundException {
        BeanDefinitionReader reader = new AnnotationBeanDefinitionReader(scanPackages);
        reader.loadBeanDefinition();
        Map<String,BeanDefinition> registry =  reader.getRegistry();
        for(Map.Entry<String,BeanDefinition> entry : registry.entrySet()){
            beanFactory.registerBeanDefinition(entry.getKey(),entry.getValue());
        }
    }
}

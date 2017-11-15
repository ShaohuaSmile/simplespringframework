package shaohua.study;

import org.junit.Test;
import shaohua.study.simpleclass.CommonService;
import shaohua.study.simplespringframework.beans.BeanDefinition;
import shaohua.study.simplespringframework.context.AnnotationApplicationContext;
import shaohua.study.simplespringframework.context.ApplicationContext;
import shaohua.study.simplespringframework.factory.AutowireBeanFactory;
import shaohua.study.simplespringframework.reader.AnnotationBeanDefinitionReader;

import java.io.IOException;
import java.lang.annotation.Target;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/14 19:50
 */
public class SimpleSpringframework {
    @Test
    public void iocTest() throws Exception {
//        AutowireBeanFactory beanFactory = new AutowireBeanFactory();
//        AnnotationBeanDefinitionReader reader = new AnnotationBeanDefinitionReader("shaohua.study.simpleclass");
//        reader.loadBeanDefinition();
//        for(Map.Entry<String,BeanDefinition> entry:reader.getRegistry().entrySet()){
//            beanFactory.registerBeanDefinition(entry.getKey(),entry.getValue());
//        }
//        CommonService commonService = (CommonService)beanFactory.getBean("commonService");
        ApplicationContext context = new AnnotationApplicationContext("shaohua.study.simpleclass");
        CommonService commonService = (CommonService)context.getBean("commonService");
        commonService.doing();
    }
}

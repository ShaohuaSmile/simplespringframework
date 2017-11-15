package shaohua.study.simplespringframework.reader;

import shaohua.study.simplespringframework.beans.BeanDefinition;

import java.io.IOException;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/14 11:54
 */
public interface BeanDefinitionReader {

    Map<String,BeanDefinition> getRegistry();

    void loadBeanDefinition() throws IOException, ClassNotFoundException;
}

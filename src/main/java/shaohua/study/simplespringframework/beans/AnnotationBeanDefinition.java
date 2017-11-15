package shaohua.study.simplespringframework.beans;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/14 17:29
 */
public class AnnotationBeanDefinition extends AutowireBeanDefinition {

    private Annotation annotation;

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }
}

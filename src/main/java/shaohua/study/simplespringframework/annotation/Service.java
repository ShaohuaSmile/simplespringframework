package shaohua.study.simplespringframework.annotation;

import java.lang.annotation.*;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/13 17:51
 */
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Service {
    String value() default "";
}

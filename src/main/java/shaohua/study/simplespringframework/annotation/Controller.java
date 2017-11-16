package shaohua.study.simplespringframework.annotation;

import java.lang.annotation.*;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/13 17:54
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface Controller {
    String value() default "";
}

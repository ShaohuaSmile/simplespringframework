package shaohua.study.simplespringframework.annotation;

import java.lang.annotation.*;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/13 17:56
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {
    String value() default "";
}

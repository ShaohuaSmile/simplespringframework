package shaohua.study.simplespringframework.annotation;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/13 17:54
 */
@Service
public @interface Controller {
    String value() default "";
}

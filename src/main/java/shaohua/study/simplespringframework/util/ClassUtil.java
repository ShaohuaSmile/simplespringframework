package shaohua.study.simplespringframework.util;

import java.lang.annotation.Annotation;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/16 16:39
 */
public class ClassUtil {
    /**
     * 功能描述: 检查类是否被annotation直接注解或间接注解
     *
     * @author Liush
     * @date 2017/11/16
     */
    public static boolean isAnnotated(Class clazz,Class annotation){
        if(clazz == null || annotation == null){
            return false;
        }

        //被直接注解
        if(clazz.isAnnotationPresent(annotation)){
            return true;
        }

        //没有被直接注解，需要找注解是否被target注解标记
        Annotation[] annotations = clazz.getAnnotations();
        if(annotations == null || annotations.length < 1){
            return false;
        }
        for(Annotation a:annotations){
            //TODO 没弄懂Annotation是个啥东西，不是普通的类？？？？
            //Class annoClass = a.getClass();
            Class annoType = a.annotationType();

            //不处理java本身的注解
            if(a.annotationType().getName().startsWith("java.lang.annotation")){
                continue;
            }
            //递归调用
            if(isAnnotated(annoType,annotation)){
                return true;
            }
        }
        return false;
    }
}

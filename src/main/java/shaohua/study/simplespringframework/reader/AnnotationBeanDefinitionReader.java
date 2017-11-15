package shaohua.study.simplespringframework.reader;

import org.apache.commons.lang3.StringUtils;
import shaohua.study.simplespringframework.annotation.Autowired;
import shaohua.study.simplespringframework.annotation.Controller;
import shaohua.study.simplespringframework.annotation.Service;
import shaohua.study.simplespringframework.beans.*;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/14 12:01
 */
public class AnnotationBeanDefinitionReader extends AbstractBeanDefinitionReader {

    private static final String CLASS_DOC = ".class";

    private final String[] packageNames;
    public AnnotationBeanDefinitionReader(String... packageNames){
        this.packageNames = packageNames;
    }
    @Override
    public void loadBeanDefinition() throws IOException, ClassNotFoundException {
        if(packageNames == null || packageNames.length == 0){
            return;
        }
        for(String packageName:packageNames){
            if(StringUtils.isBlank(packageName)){
                continue;
            }

            String packagePath = packageName.replace(".","/");
            Enumeration<URL> urls= this.getClass().getClassLoader().getResources(packagePath);

            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                String type = url.getProtocol();
                if("file".equals(type)){
                    String path = url.getPath();
                    String basePath = path.substring(0,(path.length()-packagePath.length()));
                    loadBeanDefinition(basePath,packageName);
                }else if("jar".equals(type)){
                    //todo ....
                }
            }
        }
    }

    /**
     * 功能描述: 加载指定目录下的bean
     *
     * @author Liush
     * @date 2017/11/14
     */
    private void loadBeanDefinition(String path,String javaPackage) throws ClassNotFoundException {
        //递归扫描，尝试用压栈循环
        final List<String> packageStack = new ArrayList<String>();
        packageStack.add(javaPackage);
        while(packageStack.size()>0){
            //取出队尾元素
            final String packageName = packageStack.remove(packageStack.size()-1);
            String packagePath = path + packageName.replace(".","/");
            File file = new File(packagePath);
            File[] subFiles = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory() || pathname.getName().endsWith(CLASS_DOC);
                }
            });
            for(File subFile: subFiles){
                String subFileOrDirectory = packageName+"."+subFile.getName();
                if(subFile.isDirectory()){
                    packageStack.add(subFileOrDirectory);
                }else{
                    //切掉文件类型后缀
                    String className = subFileOrDirectory.substring(0,(subFileOrDirectory.length() - CLASS_DOC.length()));
                    registerBeanDefinition(className);
                }
            }
        }

    }
    private void registerBeanDefinition(String className) throws ClassNotFoundException {
        Class clazz = Class.forName(className);
        if(clazz.isAnnotationPresent(Service.class)){
            AnnotationBeanDefinition beanDefinition = new AnnotationBeanDefinition();
            Service service = (Service) clazz.getAnnotation(Service.class);
            String name = service.value();
            if("".equals(name)){
                String simpleName = clazz.getSimpleName();
                name = simpleName.substring(0,1).toLowerCase() + simpleName.substring(1);
            }
            beanDefinition.setName(name);
            beanDefinition.setClassName(className);
            beanDefinition.setBeanClass(clazz);
            Field[] fields = clazz.getDeclaredFields();
            if(fields == null){
                return;
            }
            for(Field field:fields){
                if(field.isAnnotationPresent(Autowired.class)){
                    PropertyValue pv = new PropertyValue();
                    pv.setName(field.getName());
                    pv.setValue(new BeanReference(field.getName()));
                    beanDefinition.getPropertyValues().addProperty(pv);
                }

            }
            registry.put(name,beanDefinition);
        }
    }
}

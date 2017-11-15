package shaohua.study.simplespringframework.beans;

import java.util.*;

/**
 * 功能描述: 属性列表
 *
 * @author Liush
 * @date 2017/11/14 9:31
 */
public class PropertyValues {

    private static final Object obj= new Object();
    /** just an HashSet */
    private final Map<PropertyValue,Object> properties = new HashMap<PropertyValue,Object>();

    public void addProperty(PropertyValue pv){
        properties.put(pv,obj);
    }

    public Set<PropertyValue> getProperties(){
        return properties.keySet();
    }
}

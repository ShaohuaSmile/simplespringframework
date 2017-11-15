package shaohua.study.simplespringframework.beans;

import org.apache.commons.lang3.StringUtils;

/**
 * 功能描述: 属性对象
 *
 * @author Liush
 * @date 2017/11/14 9:29
 */
public class PropertyValue {
    private String name;
    private Object value;

    public int hashCode() {
        return name == null ? 0 :name.hashCode();
    }
    public boolean equals(Object object){
        if(object == this){
            return true;
        }
        if(object == null){
            return false;
        }
        if(object instanceof PropertyValue){
            PropertyValue pv = (PropertyValue) object;
            return StringUtils.equals(this.name,pv.name);
        }
        return false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

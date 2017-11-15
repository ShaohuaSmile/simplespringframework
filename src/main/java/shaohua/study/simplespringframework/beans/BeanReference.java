package shaohua.study.simplespringframework.beans;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/14 17:47
 */
public class BeanReference {
    private String name;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

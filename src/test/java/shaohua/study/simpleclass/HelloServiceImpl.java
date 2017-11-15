package shaohua.study.simpleclass;

import shaohua.study.simplespringframework.annotation.Service;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/14 19:54
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService{

    @Override
    public void sayHello() {
        System.out.print("-------hello---------");
    }
}

package shaohua.study.simpleclass;

import shaohua.study.simplespringframework.annotation.Autowired;
import shaohua.study.simplespringframework.annotation.Service;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/14 19:56
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {
    @Autowired
    HelloService helloService;
    @Autowired
    HelloAskService helloAskService;
    @Override
    public void doing() {
        helloService.sayHello();
        helloAskService.ask();
    }
}

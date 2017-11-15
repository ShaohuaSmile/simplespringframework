package shaohua.study.simpleclass;

import shaohua.study.simplespringframework.annotation.Service;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/15 10:50
 */
@Service("helloAskService")
public class HelloAskServiceImpl implements HelloAskService {
    @Override
    public void ask() {
        System.out.println("-ask----Hi-----");
    }
}

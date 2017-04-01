package cn.qingtianr.controller;


import cn.qingtianr.Annotation.YangController;
import cn.qingtianr.Annotation.YangRequestMapping;

/**
**  author:jack 2017年03月2017/3/26日
*/

@YangController
@YangRequestMapping(path = "/home")
public class YangHomeController {

    //todo:这里还需要将参数进行捕捉出来，实现动态绑定
    @YangRequestMapping(path = "/index")
    public void index(){
        System.out.println("It is in index method,yangHomeController.");
    }


    @YangRequestMapping(path = "/sayHello")
    public void sayHello(){
        System.out.println("Hello,everybody!");
    }
}

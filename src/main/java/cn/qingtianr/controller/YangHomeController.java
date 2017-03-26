package cn.qingtianr.controller;


/**
**  author:jack 2017年03月2017/3/26日
*/

//暂时用来匹配/home的前缀
public class YangHomeController {

    //暂时用来匹配/index的前缀,也就是说/index的请求会发送到这里来
    //todo:这里使用注解的方式进行绑定比较好
    //todo:这里还需要将参数进行捕捉出来，实现动态绑定
    public void home(){
        System.out.println("It is in home method,yangHomeController.");
    }
}

package cn.qingtianr;

import cn.qingtianr.controller.YangHomeController;
import com.sun.xml.internal.bind.v2.TODO;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
**  author:jack 2017年03月2017/3/26日
*/
public class YangHttpDispatcherServlet extends HttpServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException
    {
        HttpServletRequest  request;
        HttpServletResponse response;
        //这里通过HttpServletRequest和HttpServletResponse的种类来进行判断是否的HTTP请求
        //那除了网页的方式来进行访问也可以访问到了?
        if (!(req instanceof HttpServletRequest &&
                res instanceof HttpServletResponse)) {
            throw new ServletException("non-HTTP request or response");
        }

        request = (HttpServletRequest) req;
        response = (HttpServletResponse) res;

        service(request, response);
    }

    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
//        System.out.println("ContextPath = "+httpServletRequest.getContextPath());
        System.out.println("ServletPath = " + httpServletRequest.getServletPath());
        //PathInfo是干嘛的?
//        System.out.println("After servletPath relative path = "+httpServletRequest.getPathInfo());

        String servletPath = httpServletRequest.getServletPath();

        //TODO:Controller最好使用反射来进行初始化
        YangHomeController yangHomeController = new YangHomeController();
        //暂时进行一重判断来进行
        //todo:这里的判断需要通过扫描注解的方式进行判断，而不是硬编码
        if(servletPath.equals("/index")){
            yangHomeController.home();
        }
    }


}

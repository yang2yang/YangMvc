package cn.qingtianr;

import javax.servlet.*;
import java.io.IOException;

/**
**  author:jack 2017年03月2017/3/25日
*/
public class YangDispatcherServlet implements Servlet{

    public YangDispatcherServlet(){
        System.out.println("YangDispatcherServlet is constructed");
    }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("Now It is in init function.");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Now It is in service function.");
        String contextPath = req.getServletContext().getContextPath();
        //ServeltContext中的ContextPath是YangServlet,换一种角度也可以说是打的包的名字?
        System.out.println("ContextPath="+contextPath);
        System.out.println("RealPath="+req.getRealPath("/"));
        System.out.println("PathInfo="+"ServletRequest没有PathInfo，需要HttpServletRequest");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}

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
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}

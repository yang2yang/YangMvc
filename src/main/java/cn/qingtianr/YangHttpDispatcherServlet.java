package cn.qingtianr;

import cn.qingtianr.Annotation.YangController;
import cn.qingtianr.Annotation.YangRequestMapping;
import cn.qingtianr.util.ScanPackage;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * *  author:jack 2017年03月2017/3/26日
 */
public class YangHttpDispatcherServlet extends HttpServlet {

    private List<UrlToHandlerMapping> urlToHandlerMappingList = new ArrayList<>();

    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {
        HttpServletRequest request;
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

    /**
     * 初始化urtToHandlerMappingList
     */
    @Override
    public void init() {
        //获得指定包下面的handler
        try {
            List<Class<?>> clazzList = ScanPackage.scan("cn.qingtianr.controller");
            for (Class clazz : clazzList) {
                YangRequestMapping yangRequestMapping = (YangRequestMapping) clazz.getAnnotation(YangRequestMapping.class);
                for (Method method : clazz.getDeclaredMethods()) {
                    YangRequestMapping methodYangRequestMapping = method.getAnnotation(YangRequestMapping.class);
                    urlToHandlerMappingList.add(new UrlToHandlerMapping(method, yangRequestMapping.path() + methodYangRequestMapping.path(), clazz));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        System.out.println("ContextPath = "+httpServletRequest.getContextPath());
//        System.out.println("ServletPath = " + httpServletRequest.getServletPath());
//        PathInfo是干嘛的?
//        System.out.println("After servletPath relative path = "+httpServletRequest.getPathInfo());

        //获取到url中的相对路径进行匹配
        String servletPath = httpServletRequest.getServletPath();

        for (int i = 0; i < urlToHandlerMappingList.size(); i++) {
            if (urlToHandlerMappingList.get(i).getUrlPath().equals(servletPath)) {
                try {
                    Class<?> clazz = urlToHandlerMappingList.get(i).getClazz();
                    Object obj = clazz.newInstance();

                    Enumeration<String> enumeration = httpServletRequest.getParameterNames();

                    while(enumeration.hasMoreElements()){
                        for(Field field: clazz.getDeclaredFields()){
                            String param = enumeration.nextElement();
                            if(param.equals(field.getName())){
                                field.setAccessible(true);
                                field.set(obj,httpServletRequest.getParameter(param));
                            }
                        }
                    }
                    //反射调用真正的实现类
                    urlToHandlerMappingList.get(i).getMethod().invoke(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
                //如果找到第一个匹配的方法执行后，跳出循环
                break;
            }
        }
    }


}

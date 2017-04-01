package cn.qingtianr;

import java.lang.reflect.Method;

/**
 * Created by ding on 2017/4/1.
 */
public class UrlToHandlerMapping {
    /**
     * controller中的方法
     */
    private Method method;

    /**
     * 每个方法对应的全路径
     */
    private String urlPath;

    /**
     * 该方法中存在于哪一个类中
     */
    private Class clazz;

    public UrlToHandlerMapping(Method method,String urlPath,Class clazz){
        this.method = method;
        this.urlPath = urlPath;
        this.clazz = clazz;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
}

package cn.qingtianr.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ding on 2017/4/25.
 */
//作用于方法，类，接口
@Target({ElementType.METHOD, ElementType.TYPE})
//运行时该注解依然存在,感觉如果注解真的要使用的话，那么它的生命周期必定是RUNTIME
@Retention(RetentionPolicy.RUNTIME)
public @interface YangResponseBody {

}

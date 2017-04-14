package cn.qingtianr.util;

import cn.qingtianr.Annotation.YangController;
import cn.qingtianr.Annotation.YangRequestMapping;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ding on 2017/4/1.
 */
public class ScanPackage {

    //输入
    public static List<Class<?>> scan(String packageName) throws ClassNotFoundException, IOException {
//        String path= getSrcPath()+packageToDir(packageName);
        String path = "E:\\IdeaProjects\\base\\YangMvc\\src\\main\\java" + packageToDir(packageName);
        ClassLoader cl = ScanPackage.class.getClassLoader();

        File dir = new File(path);

        List<Class<?>> list = new ArrayList<>();
        //f.getName()的值是HomeController.java
        for (File f : dir.listFiles()) {
            //将下面的名字拼接名字的给优化掉
            String s = packageName + "." + f.getName().split("\\.")[0];
            Class clazz = Class.forName(s);
            //判断有没有下面的该目录下面的java文件有没有被YangController注解着
            //只获取被YangController注释着的Controller
            if (clazz.getAnnotation(YangController.class) != null) {
                list.add(clazz);
            }
        }

        return list;
    }

    /**
     * 获取当前路径
     */
    public static String getSrcPath() throws IOException {
        File file = new File("");
        String path = file.getCanonicalPath() + File.separator + "src";
        return path;
    }

    /**
     * package转换为路径格式
     */
    public static String packageToDir(String packageName) {
        String[] array = packageName.split("\\.");
        StringBuffer sb = new StringBuffer();
        for (String str : array) {
            sb.append(File.separator).append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
//        List<Class<?>> list = scan("cn.qingtianr.controller");
//        System.out.println(list.size());
//        for (Class<?> cla : list) {
//            System.out.println(cla.getName());
//        }

//        Class clazz = Class.forName("cn.qingtianr.controller.YangHomeController");
//        YangController yangController = (YangController) clazz.getAnnotation(YangController.class);
//        YangRequestMapping yangRequestMapping = (YangRequestMapping) clazz.getAnnotation(YangRequestMapping.class);
//        System.out.println("123");
        URL url = ClassLoader.getSystemResource("cn/qingtianr/controller");
        System.out.println(url.getPath());
    }
}
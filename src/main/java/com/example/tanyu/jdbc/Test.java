package com.example.tanyu.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/4/12 10:29
 */
public class Test {
    public static void main(String[] args) throws IOException {
//        String rootPath = new File("").getCanonicalPath() + File.separator + "src"
//                + File.separator + "main"
//                + File.separator + "java"
//                + File.separator + "com"
//                + File.separator + "example"
//                + File.separator + "tanyu"
//                + File.separator + "po";
////        File file = new File(rootPath);
////        file.mkdirs();
//
//
//
////        File file1 = new File(new File("").getCanonicalPath() + File.separator + "src"
////                + File.separator + "main"
////                + File.separator + "java"
////                + File.separator + "com"
////                + File.separator + "example"
////                + File.separator + "tanyu"
////                + File.separator + "po");
//
//        String[] fileNames = "com.example.tanyu.PO".split("\\.");
//        for (String s : fileNames) {
//            rootPath += File.separator + s;
//        }
//        File file = new File(rootPath);
//        file.mkdir();
//
////        File file2 = new File(file1.getCanonicalPath() + File.separator + "Demo.java");
////        FileOutputStream fileOutputStream = new FileOutputStream(file2);
////        fileOutputStream.write("public class Demo{xx.xx}".getBytes());
////        fileOutputStream.close();
////        file2.createNewFile();

//        String pa=new File("").getCanonicalPath() + File.separator+"src"+"main"+"resources"
        InputStream resourceAsStream = Test.class.getClassLoader().getResourceAsStream("application.yml");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        System.out.println(properties.getProperty("path"));

    }
}

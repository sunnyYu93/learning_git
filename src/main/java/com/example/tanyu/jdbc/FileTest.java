package com.example.tanyu.jdbc;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/4/10 11:43
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("");
        System.out.println(file.getCanonicalPath());

        System.out.println(System.getProperty("user.dir"));

        Properties properties = System.getProperties();
        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            Object o = enumeration.nextElement();
            System.out.println(o + properties.getProperty((String) o));
        }


    }
}

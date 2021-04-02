package com.example.tanyu.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 实现了从数据库映射到对象
 */


@Slf4j
public class Jdbc_Demo {


    /**
     * java bean 工具包
     */
    static class Utils {

        public final static Map<String, String> SQL_TYPE2JAVA_TYPE = new HashMap<>();
        public final static Map<String, String> IMPORT_PACKAGE = new HashMap<>();

        static {
            SQL_TYPE2JAVA_TYPE.put("INT", "Integer");
            SQL_TYPE2JAVA_TYPE.put("TINYINT", "Integer");
            SQL_TYPE2JAVA_TYPE.put("VARCHAR", "String");

            IMPORT_PACKAGE.put("TIMESTAMP", "import java.util.Date;");

        }


        /**
         * 生成表名的类
         *
         * @param tableName
         * @return
         */
        static String generateTableName(String tableName) {
            String clazzName = "";
            String[] split = tableName.split("_");
            StringBuffer stringBuffer = new StringBuffer();
            // jdk1.8对于字符串用+拼接，在底层会生成一个stringBuilder来优化，
            // 抛弃了之前new 多个String对象的方法
            for (String s : split) {
                clazzName += s.substring(0, 1).toUpperCase() + s.substring(1);
            }

            return clazzName;
        }

        /**
         * 生成属性
         *
         * @param columnName 列名
         * @return 根据列名生成属性名
         */
        static String generateFieldName(String columnName) {
            String fieldName = "";
            String[] split = columnName.split("_");
            // jdk1.8对于字符串用+拼接，在底层会生成一个stringBuilder来优化，
            // 抛弃了之前new 多个String对象的方法
            for (int i = 0; i < split.length; i++) {
                if (i == 0) {
                    fieldName += split[i].substring(0, 1).toLowerCase() + split[i].substring(1);
                } else {
                    fieldName += split[i].substring(0, 1).toUpperCase() + split[i].substring(1);
                }
            }
            return fieldName;
        }

        /**
         * 创建PO包名
         */

        /**
         * 生成路径
         * + File.separator + "main"
         * + File.separator + "java"
         * + File.separator + "com"
         * + File.separator + "example"
         * + File.separator + "tanyu"
         * + File.separator + "po"
         */
        public static String createDir(String pathName) {
            String path = null;
            try {
                String rootPath = new File("").getCanonicalPath() + File.separator + "src"
                        + File.separator + "main"
                        + File.separator + "java";
                String[] fileNames = pathName.split("\\.");
                for (String s : fileNames) {
                    rootPath += File.separator + s;
                }

                File file = new File(rootPath);

                file.mkdirs();
                path = file.getCanonicalPath();
                System.out.println("生成路径成功");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("生成路径失败");
            }
            return path;
        }

        /**
         * 创建类
         *
         * @param path         路径
         * @param clazzContent 类的内容
         */
        public static void writeClazz(String path, String clazzContent) {
            File file = new File(path);
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(clazzContent.getBytes());
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }


        }

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        InputStream resourceAsStream = Test.class.getClassLoader().getResourceAsStream("application.yml");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        System.out.println(properties.getProperty("path"));

//        String url = "jdbc:mysql://139.9.215.41:3306/test?autoReconnect=true&useSSL=false";
//        String driver = "com.mysql.cj.jdbc.Driver";
//        String userName = "root";
//        String password = "930903tanyu";

        String url = (String) properties.get("url");
        String driver = (String) properties.get("driver");
        String userName = (String) properties.get("userName");
        String password = (String) properties.get("password");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, userName, password);
        //获取数据库的源信息
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet metaDataTables = metaData.getTables("test", null, null, null);
        String packegeName = "com.example.tanyu.PO";
        String packagePath = Utils.createDir(packegeName);


        while (metaDataTables.next()) {
            String tableName = metaDataTables.getString(3);
            StringBuilder contentBuilder = new StringBuilder();
            ResultSet columns = metaData.getColumns("test", null, tableName, null);

            Map<String, String> dataMap = new HashMap<>();

            while (columns.next()) {
                //columnName:数据库中自定义列名
                String columnName = columns.getString("COLUMN_NAME");
                //dataType:数据库中自定义列属性，如：TINYINT，VARCHAR
                String dataType = columns.getString("TYPE_NAME");
                System.out.println(columnName + " " + dataType);

                dataMap.put(columnName, dataType);
            }

            /**
             * 1、导包
             * 2、创建类
             * 3、构建属性
             * 4、封装
             */

            contentBuilder.append("package " + packegeName + ";" + "\n" + "\n");
            Set<Map.Entry<String, String>> entrySet = dataMap.entrySet();

            // 1、导包
            for (Map.Entry<String, String> entry : entrySet) {
                String necessaryImport = Utils.IMPORT_PACKAGE.get(entry.getValue());

                if (necessaryImport != null) {
                    contentBuilder.append(necessaryImport + "\n");
                }
            }
            //2、构建类信息
            String generateTableName = Utils.generateTableName(tableName);
            contentBuilder.append("public class " + " " + generateTableName + " {" + "\n");
            // 构建属性信息
            for (Map.Entry<String, String> entry : entrySet) {
                contentBuilder.append("\t" + "private" + " " + Utils.SQL_TYPE2JAVA_TYPE.get(entry.getValue())
                        + " " + Utils.generateFieldName(entry.getKey()) + ";" + "\n");
            }
            contentBuilder.append("}");

            System.out.println("\n");
            Utils.writeClazz(packagePath + File.separator + generateTableName + ".java", contentBuilder.toString());

        }

    }
}

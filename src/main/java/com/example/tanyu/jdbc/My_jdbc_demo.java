package com.example.tanyu.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/4/10 9:50
 */
public class My_jdbc_demo {

    static class Utils {

        private final static Map<String, String> SQL_JAVA = new HashMap<>();
        private static Map<String, String> PACKAGE_MAP = new HashMap<>();

        public Map<String, String> getSQL_JAVA() {
            return SQL_JAVA;
        }

        public Map<String, String> getPACKAGE_MAP() {
            return PACKAGE_MAP;
        }

        static {
            SQL_JAVA.put("INT", "Integer");
            SQL_JAVA.put("TINYINT", "Integer");
            SQL_JAVA.put("VARCHAR", "String");

            PACKAGE_MAP.put("TIMESTAMP", "import java.util.Date;");
        }

        //生成类名
        public static String generateClassName(String tableName) {
            StringBuilder className = new StringBuilder();
            String[] split = tableName.split("_");
            StringBuilder builder = new StringBuilder();
            for (String s : split) {
                className.append(s.substring(0, 1).toUpperCase()).append(s.substring(1));
            }
            return className.toString();

        }

        public static String generateFieldName(String columnName) {
            String fieldName = "";
            String[] split = columnName.split("_");
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                if (i == 0) {
                    fieldName += split[i].substring(0, 1).toLowerCase() + split[i].substring(1);

                } else {
                    fieldName += split[i].substring(0, 1).toUpperCase() + split[i].substring(1);

                }
            }
            return fieldName;
        }


    }


    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://139.9.215.41:3306/test", "root", "930903tanyu");
        System.out.println(connection.toString());
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet metaDataTables = metaData.getTables("test", null, null, null);
        while (metaDataTables.next()) {
            String tableName = metaDataTables.getString(3);
            ResultSet columnSet = metaData.getColumns("test", null, tableName, null);

            Map<String, String> dataHashMap = new HashMap<>();
            while (columnSet.next()) {
                String columnName = columnSet.getString("COLUMN_NAME");
                String typeName = columnSet.getString("TYPE_NAME");

                dataHashMap.put(columnName, typeName);
//                System.out.println("columnName：" + columnName + " " + "typeName：" + typeName);
            }

            /**
             * 1、导包
             * 2、创建类
             * 3、构建属性
             * 4、封装
             */

            StringBuilder stringBuilder = new StringBuilder();
            Set<Map.Entry<String, String>> entrySet = dataHashMap.entrySet();

            for (Map.Entry<String, String> entry : entrySet) {

                String importPack = Utils.PACKAGE_MAP.get(entry.getValue());
                if (importPack != null) {
                    stringBuilder.append(importPack).append("\n");
                }

            }

            stringBuilder.append("public class" + " "
                    + Utils.generateClassName(tableName) + " " + "{" + "\n");

            for (Map.Entry<String, String> entry : entrySet) {
                stringBuilder.append("\t" + "private" + " " + Utils.SQL_JAVA.get(entry.getValue()) + " "
                        + Utils.generateFieldName(entry.getKey()) + ";" + "\n");

            }
            stringBuilder.append("}");

            System.out.println(stringBuilder.toString());


        }
    }


}

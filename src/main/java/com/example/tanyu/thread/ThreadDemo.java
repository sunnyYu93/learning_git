package com.example.tanyu.thread;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/4/17 12:07
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadDemo {
    public static int count = 1;
    public static String fileNameFormat = "A%d";

    static class MyClassLoader extends ClassLoader {
        static {
            System.out.println(ClassLoader.registerAsParallelCapable());
        }

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return super.loadClass(name, true);
        }
    }

    public static void main(String[] args) throws Exception {
        test();
    }

    public static void test() throws Exception {
        final ExecutorService executorService = Executors.newCachedThreadPool(
        );
        final ClassLoader classLoader = new MyClassLoader();
        for (int i = 0; i < 10000; i++) {
            int j = i;
            executorService.execute(() -> {
                try {
                    final Class<?> aClass = classLoader.loadClass(String.
                            format("com.nickle.feigndemo.A%d", j));
                    aClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(count);
    }

    public static void create() throws Exception {

        String content =
                "package com.nickle.feigndemo;\n\n" +
                        "public class %s {\n" +
                        "    static{\n" +
                        "        ThreadDemo.count++;\n" +
                        "    }\n" +
                        "}";
        String filePath = "C:\\Users\\nickle\\Desktop\\spring-cloud\\feign- demo\\src\\test\\java\\com\\nickle\\feigndemo\\";
        String filePathFormat = filePath + "%s";
        for (int i = 0; i < 10000; i++) {
            String fileName = String.format(fileNameFormat, i);
            String format = String.format(filePathFormat, fileName) + ".java";
            File file = new File(format);
            System.out.println(file.getCanonicalPath());
            if (file.exists()) {
                continue;
            }
            file.createNewFile();
            try (BufferedWriter bufferedWriter = new BufferedWriter(new
                    OutputStreamWriter(new FileOutputStream(file)))) {
                bufferedWriter.write(String.format(content, fileName));
            }

        }
    }
}
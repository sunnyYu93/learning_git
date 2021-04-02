package com.example.tanyu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.File;
import java.io.IOException;

@SpringBootTest
class TanyuApplicationTests {

    @Test
    void contextLoads() throws IOException {

        String rootPath = new File("").getCanonicalPath() + File.separator + "src"
                + File.separator + "main"
                + File.separator + "java"
                + File.separator + "com"
                + File.separator + "example"
                + File.separator + "tanyu"
                + File.separator + "po";
    }

}

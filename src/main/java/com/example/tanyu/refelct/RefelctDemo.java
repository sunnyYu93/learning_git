package com.example.tanyu.refelct;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

class Student {
    public Student() {
    }

    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    private String name = "小汪汪";
    private int age = 18;

    public String sex = "女";

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class RefelctDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<Student> studentClass = Student.class;
        Constructor constructor = studentClass.getConstructor();
        Object o = constructor.newInstance();
        System.out.println(o);

//        Field name = studentClass.getDeclaredField("name");
//        name.setAccessible(true);
//        Object obj = null;
//        name.set(obj,"haha");
//        Field[] fields = studentClass.getFields();
//        for (Field f : fields) {
//            System.out.println(f.getName());
//
//        }

//        Field[] declaredFields = studentClass.getDeclaredFields();
//        for (Field f : declaredFields) {
//
//            System.out.println(f.getName());
//        }


//        //获取String所对应的Class对象
//        Class<?> c = String.class;
////获取String类带一个String参数的构造器
//        Constructor constructor = c.getConstructor(String.class);
////根据构造器创建实例
//        Object obj = constructor.newInstance("23333");
//        System.out.println(obj);

    }
}

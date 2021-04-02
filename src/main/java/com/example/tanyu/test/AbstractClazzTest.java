package com.example.tanyu.test;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/3 9:47
 */
public abstract class AbstractClazzTest {
    public AbstractClazzTest() {
        print();
    }

    abstract void print();
}

class T extends AbstractClazzTest{

    int a =7;
    public static void main(String[] args) {
        T t = new T();
        t.print();
    }

    @Override
    void print() {
        System.out.println(a);
    }
}

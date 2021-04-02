package com.example.tanyu.test;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/9 17:33
 */
public abstract class Person {
    public abstract String getDescription();

    void test() {
        System.out.println("haha");
    }

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Employee extends Person {

    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }


    @Override
    public String getDescription() {
        return String.format("这是一个雇员，工资为$%.2f", salary);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

}

class Student extends Person {

    private String major;

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "这是一个专业为" + major + "的学生";
    }
}

class Test {
    public static void main(String[] args) {
        Person[] people = new Person[2];
        people[0] = new Employee("小李", 5000);
        people[1] = new Student("小王", "物理");
        for (Person p :
                people) {
            System.out.println(p.getName() + "," + p.getDescription());
        }
    }
}

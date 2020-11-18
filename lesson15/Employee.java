package lesson15;

public class Employee {

    protected String name;
    protected String position;
    protected String email;
    protected String phone;
    protected int salary;
    protected int age;

    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public Employee() {     // перегруженный конструктор: при вызове без параметров вызывает другой конструктор
        this(null, null, null, null, 0, 0);
    }

    public void printEmployee() {
        System.out.println(name);
        System.out.println("------------------------------------");
        System.out.println("Возраст: " + age);
        System.out.println("Должность: " + position);
        System.out.println("email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("====================================");
        System.out.println();
    }

}

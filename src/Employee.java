/**
 * Created by Mihnea on 26.04.2017.
 */
public class Employee {
    public String name = "Unknown";
    public int age;

    public Employee(String name) {
        this.name=name;
    }
    public Employee(){
        this.name="Unknown";
    }

    public Employee(String name, int age) {
        this.name=name;
        this.age = age;
    }
    public void setName(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public static void print() {
        System.out.println("Inside Employee Superclass.");
    }
}
class Manager extends Employee {
    private String name = "Johnny;";

    public Manager(String name) {
        super(name);
    }
    public Manager() {
        super();
    }

    public Manager(String name, int age) {
        super(name, age);
    }

    public static void print() {
        System.out.println("Inside Manager Subclass.");
    }
}
class ManagerTest {
    public static void main(String[] args) {
        Manager mgr = new Manager("SefPatron",35);
        String name = mgr.getName();
        System.out.println("Manager name: "+name);
        Manager mgr2 = new Manager("John",28);
        Employee emp1 = new Manager("Jack",27); // print() goes to superclass
        Employee emp2 = new Employee("Jill",30);
        Employee.print();
        mgr2.print();
        Manager.print();
        emp1.print();
        Employee.print();
        emp2.print();
        emp1=mgr2;
        emp1.print();
        ((Manager)emp1).print();
        Manager m = new Manager();
        System.out.println(m.getName());
    }
}

package godofjava.c.middle;

public class CalculateSalary {
    public static void main(String[] args) {
        CalculateSalary cs = new CalculateSalary();
        cs.calculateSalaries();
    }

    public void calculateSalaries() {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Lee", 1, 1_000_000_000);
        employees[1] = new Employee("Kim", 2, 100_000_000);
        employees[2] = new Employee("Whang", 3, 70_000_000);
        employees[3] = new Employee("Park", 4, 80_000_000);
        employees[4] = new Employee("LeeDevelop", 5, 60_000_000);

        for (Employee employee: employees) {
            System.out.println(employee.getName() + "="  + getSalaryIncrease(employee));
        }
    }

    public long getSalaryIncrease(Employee employee) {
        double increaseRate = 0.0;
        switch (employee.getType()) {
            case 1:
                increaseRate = -0.95;
                break;
            case 2:
                increaseRate = 0.1;
                break;
            case 3:
                increaseRate = 0.2;
                break;
            case 4:
                increaseRate = 0.3;
                break;
            case 5:
                increaseRate = 1.0;
                break;
            default:
        }

        return (long) (employee.getSalary() * (1 + increaseRate));
    }
}

class Employee {
    private String name;
    private int type;
    private long salary;

    public int getType() {
        return type;
    }

    public long getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Employee(String name, int type, long salary) {
        this.name = name;
        this.type = type;
        this.salary = salary;
    }
}
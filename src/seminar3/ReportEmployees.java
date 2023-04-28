package seminar3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


public class ReportEmployees {
    private static Random random = new Random();

    public static Employee generateEmployee() {
        String[] names = new String[]{"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман"};
        String[] surnames = new String[]{"Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов"};

        int salary = random.nextInt(1000, 2000);
        int salaryIndex = random.nextInt(28, 31);
        int countDays = random.nextInt(1, 25);
        int countHours = random.nextInt(1, 5);
        if (Math.random() > 0.51) {
            return new Worker(names[random.nextInt(10)], surnames[random.nextInt(10)], random.nextInt(18, 66), salary * salaryIndex);
        } else {
            return new Freelancer(names[random.nextInt(10)], surnames[random.nextInt(10)], random.nextInt(18, 66), salary, countDays, countHours);
        }
    }

    public static void main(String[] args) {


        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = generateEmployee();
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Arrays.sort(employees, new DescendingSalaryComparator());

        System.out.println("\n*** Отсортированный по убыванию месячной заработной платы список сотрудников ***\n");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Arrays.sort(employees, new AscendingSalaryComparator());

        System.out.println("\n*** Отсортированный по возрастанию месячной заработной платы список сотрудников ***\n");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Arrays.sort(employees, new SurNameComparator());

        System.out.println("\n*** Отсортированный по фамилиям в алфавитном порядке список сотрудников ***\n");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Arrays.sort(employees, new AgeComparator());

        System.out.println("\n*** Отсортированный по увеличению возраста список сотрудников ***\n");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }

}

class DescendingSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {

        return Double.compare(o2.calculateSalary(), o1.calculateSalary());
    }
}
class AscendingSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {

        return Double.compare(o1.calculateSalary(), o2.calculateSalary());
    }
}
    class SurNameComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {

            return o1.surName.compareTo(o2.surName);
        }

    }
class AgeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {

        return Integer.compare(o1.age, o2.age);
    }
}

abstract class Employee implements Comparable<Employee>{

    protected String firstName;
    protected String surName;
    protected double salary;  //это ставка (часовая у фрилансера или месячная у основного работника)
    protected int age;

    public Employee(String firstName, String surName, int age, double salary) {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
        this.salary = salary;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Возраст: %d лет; Заработная плата за месяц: %.2f",
                surName, firstName, age, calculateSalary());
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(calculateSalary(), o.calculateSalary());
    }
}


class Worker extends Employee{

    public Worker(String firstName, String surName, int age, double salary) {
        super(firstName, surName, age, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s: Рабочий; Возраст: %d; Заработная плата за месяц: %.2f",
                surName, firstName, age, calculateSalary());
    }
}

    class Freelancer extends Employee {
        protected int countDays;
        protected int countHours;

        public Freelancer(String firstName, String surName, int age, double salary, int countDays, int countHours) {
            super(firstName, surName, age, salary);
            this.countDays = countDays;
            this.countHours = countHours;
        }

        @Override
        public double calculateSalary() {
            return salary * countDays * countHours;
        }

        @Override
        public String toString() {
            return String.format("%s %s: Фрилансер; Возраст: %d; Заработная плата за месяц: %.2f",
                    surName, firstName, age, calculateSalary());
        }
    }

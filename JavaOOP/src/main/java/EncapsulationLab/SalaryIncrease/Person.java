package EncapsulationLab.SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName,int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age =  age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void increaseSalary(double bonus){
        double reduce = age < 30 ? bonus/ 2 : bonus;
        double factor = 1.00 + reduce/100;
        salary = salary * factor;

    }

    public String toString(){
        return String.format("%s %s gets %.2f leva",firstName,lastName,salary);
    }
}



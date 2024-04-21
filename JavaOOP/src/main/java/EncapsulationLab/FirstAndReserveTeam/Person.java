package EncapsulationLab.FirstAndReserveTeam;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName,int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age =  age;
//        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3){
            throw new IllegalStateException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3){
            throw new IllegalStateException("Last name cannot be less than 3 symbols");
        }

        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 460){
            throw new IllegalStateException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0){
            throw new IllegalStateException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }


    public void increaseSalary(double bonus){
        double reduce = age < 30 ? bonus/ 2 : bonus;
        double factor = 1.00 + reduce/100;
        setSalary(salary * factor);

    }

    public String toString(){
        return String.format("%s %s gets %.2f leva",firstName,lastName,salary);
    }
}



package DefiningClassesExercises.CompanyRoster;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;


    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;

    }

    public int getAge() {
        return age;
    }
    @Override
    public String toString(){
        return String.format("%s - %d", this.getName(), this.getAge());
    }

}

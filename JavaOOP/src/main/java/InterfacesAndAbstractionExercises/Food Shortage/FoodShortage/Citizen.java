public class Citizen implements Person, Identifiable,Birthable,Buyer{
    private String name;
    private int age;

    private String id;
    private String birthDate;

    private int food;

    public Citizen(String name, int age,String id,String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void buyFood() {
       this.food += 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}

package InterfacesAndAbstractionLab.SayHello.SayHello;

public abstract class BasePerson implements Person{
    private String name;

    public BasePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }


    public abstract String sayHello();


}

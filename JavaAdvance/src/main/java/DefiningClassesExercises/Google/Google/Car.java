package DefiningClassesExercises.Google.Google;

public class Car {
    private String model;
    private int speed;

    public Car(String model,int speed){
        this.model = model;
        this.speed = speed;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setSpeed(int speed){
        this.speed =  speed;
    }
    public String getModel(){
        return this.model;
    }

    public int getSpeed() {
        return speed;
    }
    public String format(){
        return String.format("%s %d",model,speed);
    }
}

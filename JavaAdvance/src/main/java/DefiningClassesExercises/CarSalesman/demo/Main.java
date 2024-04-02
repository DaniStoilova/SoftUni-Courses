package DefiningClassesExercises.CarSalesman.demo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException {

        Scanner scanner = new Scanner(System.in);


                int n = Integer.parseInt(scanner.nextLine());

                LinkedList<Engine> engines = new LinkedList<>();
                LinkedList<Car>cars = new LinkedList<>();

                for (int i = 0; i < n; i++) {
                    String[]engine = scanner.nextLine().split(" ");
                    String model = engine[0];
                    int power = Integer.parseInt(engine[1]);
                    Engine engine1 = null;

                    if (engine.length == 4){
                        String displacement = engine[2];
                        String efficiency = engine[3];
                        engine1 = new Engine(model,power,displacement,efficiency);
                    }else if(engine.length==3){
                        if (isNum(engine[2])){
                            engine1 = new Engine(model,power,engine[2],"n/a");
                        }else{
                            engine1 = new Engine(model,power,"n/a",engine[2]);
                        }
                    }else{
                        engine1 = new Engine(model,power);
                    }
                    engines.add(engine1);
                }
                int m = Integer.parseInt(scanner.nextLine());

                for (int i = 0; i < m; i++) {
                    Car car = null;
                    String[]carsInput = scanner.nextLine().split(" ");
                    String model = carsInput[0];
                    String engineName = carsInput[1];
                    Engine engine = null;
                    for (Engine engine1 : engines) {
                        if (engine1.getModel().equals(engineName)){
                            engine=engine1;
                            break;
                        }
                    }
                    if (carsInput.length==4){
                        String weight = carsInput[2];
                        String color = carsInput[3];
                        car = new Car(model,engine,weight,color);
                    }else if(carsInput.length==3){
                        if (isNum(carsInput[2])){
                            String weight = carsInput[2];
                            car=new Car(model,engine,weight,"n/a");
                        }else{
                            String color = carsInput[2];
                            car=new Car(model,engine,"n/a",color);
                        }
                    }else{
                        car=new Car(model,engine);
                    }
                    cars.add(car);
                }

                for (Car car : cars) {
                    System.out.println(car.toString());
                }
            }

            private static boolean isNum(String s) {
                try{
                    Integer.parseInt(s);
                    return true;
                }catch (NumberFormatException ex){
                    return false;
                }
            }
        }




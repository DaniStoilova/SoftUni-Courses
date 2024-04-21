package WorkingWthAbstractionExercise.TrafficLights.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lights = scanner.nextLine().split(" ");

        int numOfTimes = Integer.parseInt(scanner.nextLine());

        List<TrafficLight> trafficLightList = new ArrayList<>();


        for (String light : lights) {
            Color color = Color.valueOf(light);
            TrafficLight trafficLight = new TrafficLight(color);
            trafficLightList.add(trafficLight);
        }

        for (int i = 0; i < numOfTimes; i++) {
            for (TrafficLight light : trafficLightList) {
                light.changeColor();
                System.out.print(light.getColor() + " ");
            }
            System.out.println();
        }


    }
}

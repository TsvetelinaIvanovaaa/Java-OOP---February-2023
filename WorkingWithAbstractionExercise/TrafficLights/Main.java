package WorkingWithAbstractionExercise.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //цветовете на крушките в началото
        String [] colors = scanner.nextLine().split("\\s+");
        //брой на смените
        int n = Integer.parseInt(scanner.nextLine());

        //светофар -> съвкупност от крушки
        List<Light> trafficLight = new ArrayList<>(); //списък със всички крушки

        for (String color:colors) {
            //създавам крушка с този цвят
            Light light = new Light(Color.valueOf(color));
            trafficLight.add(light);
        }

        for (int i = 0; i < n; i++) {
            trafficLight.forEach(light -> {
                light.changeColor();
                System.out.print(light.getColor() + " ");
            });
            System.out.println();
        }
    }
}

package ReflectionLab.BlackBoxInteger.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        String input = scanner.nextLine();

        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);


        while (!input.equals("END")) {
            String[] data = input.split("_");
            String methodName = data[0];
            int value = Integer.parseInt(data[1]);

            Method method = clazz.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt,value);


            System.out.println(innerValue.get(blackBoxInt));


            input = scanner.nextLine();
        }

    }

}


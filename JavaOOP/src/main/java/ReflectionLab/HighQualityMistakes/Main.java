package ReflectionLab.HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);


        Class reflection = Reflection.class;


        Field[] fields = reflection.getDeclaredFields();


        Arrays.stream(fields).filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.printf("%s must be private!%n",field.getName()));

        Method [] methods = reflection.getDeclaredMethods();

        Arrays.stream(methods).filter(method -> method.getName().startsWith("get")
                && method.getParameterCount() == 0)
                .filter(field -> !Modifier.isPublic(field.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(e -> System.out.printf("%s have to be public!%n",e.getName()));

        Arrays.stream(methods).filter(method -> method.getName().startsWith("set")
                        && method.getParameterCount() == 1)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(e -> System.out.printf("%s have to be private!%n",e.getName()));






    }
}

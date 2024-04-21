package ReflectionLab.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);


        Class reflection = Reflection.class;

        System.out.println(reflection);
        Class superClass = reflection.getSuperclass();
        System.out.println(superClass);
        Class[] interfaces = reflection.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);

        Object constructorReflection = reflection.getDeclaredConstructor().newInstance();
        System.out.println(constructorReflection);






    }
}

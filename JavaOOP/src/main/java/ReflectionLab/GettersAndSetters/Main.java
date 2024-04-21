package ReflectionLab.GettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);


        Class reflection = Reflection.class;

        Method [] methods = reflection.getDeclaredMethods();

        Arrays.stream(methods).filter(method -> method.getName().startsWith("get")
                && method.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(e -> System.out.printf("%s will return class %s%n",e.getName(),e.getReturnType().getName()));

        Arrays.stream(methods).filter(method -> method.getName().startsWith("set")
                        && method.getParameterCount() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(e -> System.out.printf("%s and will set field of class %s%n",e.getName(),
                        e.getParameterTypes()[0].getName()));






    }
}

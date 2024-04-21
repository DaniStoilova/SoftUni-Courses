package ReflectionLab.HarvestingFields.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//Class<RichSoilLand> clazz = RichSoilLand.class;
		Class clazz = RichSoilLand.class;

		Field [] fields = clazz.getDeclaredFields();

		String input = scanner.nextLine();

		while (!input.equals("HARVEST")) {

			switch (input){
				case "public":
					Arrays.stream(fields).filter(field -> Modifier.isPublic(field.getModifiers()))
							.forEach(f -> System.out.printf("%s %s %s%n",
									Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
					break;
				case "private":
					Arrays.stream(fields).filter(field -> Modifier.isPrivate(field.getModifiers()))
							.forEach(f -> System.out.printf("%s %s %s%n",
									Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
					break;
				case "protected":
					Arrays.stream(fields).filter(field -> Modifier.isProtected(field.getModifiers()))
							.forEach(f -> System.out.printf("%s %s %s%n",
											Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
					break;

				case "all":
					Arrays.stream(fields)
							.forEach(f -> System.out.printf("%s %s %s%n",
									Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));

			}

			input = scanner.nextLine();
		}

	}
}

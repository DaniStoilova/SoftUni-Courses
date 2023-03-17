package TextProcessingExercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        String[] folder = path.split("\\\\");

        String fileName = folder[folder.length - 1];

        String name = fileName.split("\\.")[0];
        String extension = fileName.split("\\.")[1];

        System.out.println("File name: " + name);
        System.out.println("File extension: " + extension);


    }
}

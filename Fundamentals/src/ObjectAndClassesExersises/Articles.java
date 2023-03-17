package ObjectAndClassesExersises;

import java.util.Scanner;

public class Articles {
    // static class Article{
    private String title;
    private String content;
    private String author;

    public Articles(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void edit(String newContent) {
        this.content = newContent;
    }

    public void changeAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void rename(String newTitle) {
        this.title = newTitle;
    }
    @Override
    public String toString(){
        return this.title + " - " + this.content + ": " + this.author;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String articleDate = scanner.nextLine();
        String command[] = articleDate.split(", ");
        String title = command[0];
        String content = command[1];
        String author = command[2];

        Articles articles = new Articles(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String line = scanner.nextLine();
            String commandLine = line.split("\\: ")[0];
            String newValue = line.split("\\: ")[1];

            switch (commandLine) {
                case "Edit":
                    articles.edit(newValue);
                    break;
                case "ChangeAuthor":
                    articles.changeAuthor(newValue);
                    break;
                case "Rename":
                    articles.rename(newValue);
                    break;
            }

        }
        System.out.println(articles.toString());
    }
}

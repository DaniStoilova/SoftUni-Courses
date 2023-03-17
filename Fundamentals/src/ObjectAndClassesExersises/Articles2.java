package ObjectAndClassesExersises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articles2 {
    static class Articles {
        String title;
        String content;
        String author;

        public Articles(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return this.title;
        }

        public String getContent() {
            return this.content;
        }

        public String getAuthor() {
            return this.author;
        }

        @Override

        public String toString() {
            return this.title + " - " + this.content + ": " + this.author;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Articles> articlesList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] commandLine = scanner.nextLine().split(", ");
            String title = commandLine[0];
            String content = commandLine[1];
            String author = commandLine[2];

            Articles articles = new Articles(title, content, author);
            articlesList.add(articles);

        }

        for (Articles articles : articlesList) {
            System.out.println(articles.toString());
        }


    }
}

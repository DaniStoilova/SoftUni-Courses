package ObjectAndClassesExersises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    static class Person{
      private String name;
      private String id;
      private int age;

      public Person(String name,String id,int age){
          this.name = name;
          this.id = id;
          this.age = age;

      }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> personList = new ArrayList<>();
        while (!input.equals("End")){
            String[] personalData = input.split(" ");
            String name = personalData[0];
            String id = personalData[1];
            int age =Integer.parseInt(personalData[2]);

            Person person = new Person(name,id,age);
            personList.add(person);



            input = scanner.nextLine();
        }

        personList.sort(Comparator.comparingInt(Person::getAge));

        for (Person person:personList) {
            System.out.printf("%s with ID: %s is %d years old.%n",person.getName(),person.getId(),person.getAge());
        }

    }
}

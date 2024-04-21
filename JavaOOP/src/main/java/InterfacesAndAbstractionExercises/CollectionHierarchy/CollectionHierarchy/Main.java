package InterfacesAndAbstractionExercises.CollectionHierarchy.CollectionHierarchy;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myListImp = new MyListImpl();

        String [] data = scanner.nextLine().split(" ");
        int num = Integer.parseInt(scanner.nextLine());

       addOperation(data,addCollection);
       addOperation(data,addRemoveCollection);
       addOperation(data,myListImp);

       removeOperation(num,addRemoveCollection);
       removeOperation(num,myListImp);


    }
    private static void removeOperation(int num, AddRemovable addRemovable) {
        for (int i = 0; i < num; i++) {
            System.out.print(addRemovable.remove() + " ");


        }
        System.out.println();
    }

    private static void addOperation(String[] data,Addable addable) {
        for (String word : data) {
            System.out.print(addable.add(word) + " ");
            
        }
        System.out.println();
    }
}

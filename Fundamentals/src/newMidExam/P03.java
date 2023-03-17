package newMidExam;

import java.util.*;
import java.util.stream.Collectors;

public class P03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> productList = Arrays
                .stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Shop!")){
            String[] command = input.split("%");
            String line = command[0];

            switch (line){
                case "Important":
                    String product = command[1];

                    if (productList.contains(product)) {

                        productList.remove(product);
                        productList.add(0, product);

                    }else{
                        productList.add(0, product);
                    }

                    break;
                case "Add":
                    String productToAdd = command[1];

                    if (!productList.contains(productToAdd)){
                        productList.add(productToAdd);
                    }else{
                        System.out.println("The product is already in the list.");
                    }

                    break;
                case "Swap":
                    String product1 = command[1];
                    String product2 = command[2];


                    if (productList.contains(product1) && productList.contains(product2)){

                        int indexProduct1 = productList.indexOf(product1);
                        int indexProduct2 = productList.indexOf(product2);

                        productList.set(indexProduct1,product2);
                        productList.set(indexProduct2,product1);

                    }else if (!productList.contains(product1) || !productList.contains(product2)){
                        if (!productList.contains(product1)){
                            System.out.printf("Product %s missing!%n", product1);
                        }else{
                            System.out.printf("Product %s missing!%n", product2);
                        }
                    }



                    break;
                case "Remove":
                    String productToRemove = command[1];

                    if (productList.contains(productToRemove)){
                        productList.remove(productToRemove);
                    }else{
                        System.out.printf("Product %s isn't in the list.%n",productToRemove);
                    }

                    break;
                case "Reversed":

                    Collections.reverse(productList);


                    break;
            }


            input = scanner.nextLine();
        }


        for (int i = 0; i < productList.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, productList.get(i));
        }

//        for (String item:productList) {
//            int index = productList.indexOf(item) + 1;
//            System.out.println(index+"." + " " + item);
//        }

    }
}

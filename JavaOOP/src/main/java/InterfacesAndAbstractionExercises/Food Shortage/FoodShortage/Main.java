import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Buyer buyer;

        Map<String ,Buyer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String [] data= scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            if (data.length == 4){
                String id = data[2];
                String birthDate = data[3];

                buyer = new Citizen(name,age,id,birthDate);



            }else {
                String group = data[2];

                buyer = new Rebel(name,age,group);


            }
            if (!map.containsKey(name)){
                map.put(name,buyer);
            }
        }

        String input = scanner.nextLine();

        while (!"End".equals(input)){
          Buyer buyer1 = map.get(input);
          if (buyer1 != null){
              buyer1.buyFood();
          }


            input = scanner.nextLine();
        }



       int sum =  map.values().stream().mapToInt(Buyer::getFood).sum();


        System.out.println(sum);







    }
}

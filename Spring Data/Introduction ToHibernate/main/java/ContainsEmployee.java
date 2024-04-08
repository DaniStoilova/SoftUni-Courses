import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class ContainsEmployee {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery
                ("FROM Employee WHERE CONCAT(first_name,' ',last_name) = :name", Employee.class);

        List<Employee> employeeList =  query.setParameter("name", name).getResultList();

        if(!employeeList.isEmpty()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

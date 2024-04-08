import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Scanner;

public class GetEmployeesWithProject {
    public static void main(String[] args) {

        EntityManager entityManager = Utils.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        int employeeId = Integer.parseInt(scanner.nextLine());

        entityManager.getTransaction().begin();

        Query query =  entityManager.createQuery("FROM Employee WHERE id = :employeeId",
                Employee.class);

        query.setParameter("employeeId", employeeId)
                .getSingleResult().toString();




        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

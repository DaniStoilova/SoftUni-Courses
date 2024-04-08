import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class FindEmployeesByFirstName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String letter = scanner.nextLine();

        EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery
                ("FROM Employee WHERE firstName LIKE CONCAT(:letters, '%')",Employee.class);

        query.setParameter("letters",letter);

        List<Employee> employeeList = query.getResultList();

        for (Employee e : employeeList) {
            System.out.printf("%s %s - %s - ($%s)%n",
            e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary());
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}


import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;


public class EmployeesMaximumSalaries {
    public static void main(String[] args) {

        EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();



        Query query = entityManager.createQuery("SELECT department.name, max(salary)" +
                        " FROM Employee " +
                        " GROUP BY department.name" +
                        " HAVING max(salary) NOT BETWEEN 30000 AND 70000", Object[].class);

        List<Object[]> employeeList = query.getResultList();

        for (Object[] objects : employeeList) {
            System.out.printf("%s %.2f%n",objects[0], objects[1]);
        }


        entityManager.getTransaction().commit();
        entityManager.close();

    }
}

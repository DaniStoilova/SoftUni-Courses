import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EmployeesWithASalaryOver50000 {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery
                ("FROM Employee e WHERE e.salary > 50000" , Employee.class);

        List<Employee> list = query.getResultList();

        for (Employee employee : list) {
            System.out.printf("%s%n",employee.getFirstName());
        }


//        List<String> list;
//        list = entityManager.createQuery
//                ("Select e.firstName FROM Employee e WHERE e.salary > 50000"
//                        , String.class).getResultList();
//
//        for (String s : list) {
//            System.out.printf("%s%n",s);
//        }


        entityManager.getTransaction().commit();
        entityManager.close();

    }
}

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager
                .createQuery
                        ("FROM Employee WHERE department.name = :departmentName " +
                                "ORDER BY salary,id", Employee.class);

        query.setParameter("departmentName", "Research and Development");
        List<Employee> employeeList= query.getResultList();

        employeeList.forEach(f->
                System.out.printf("%s %s from Research and Development - $%s%n",
                        f.getFirstName(),f.getLastName(),f.getSalary()));


        entityManager.getTransaction().commit();
        entityManager.close();


    }
}

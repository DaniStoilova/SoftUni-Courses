import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

public class IncreaseSalaries {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery
                ("FROM Employee WHERE department.name in (:departmentName)",Employee.class);

        List<Object> listDepartments = List.of("Engineering","Tool Design","Marketing","TInformation Services");
        query.setParameter("departmentName", listDepartments);

              List<Employee> employeeList = query.getResultList();

        for (Employee employee : employeeList) {
            employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
            System.out.printf("%s %s ($%.2f)%n",employee.getFirstName(),employee.getLastName(),
                    employee.getSalary());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

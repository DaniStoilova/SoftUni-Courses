import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class AddingANewAddressAndUpdatingTheEmployee {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);

        String lastName = scanner.nextLine();

        String addressNew = "Vitoshka 15";
        Address address = new Address();
        address.setText(addressNew);
        entityManager.persist(address);

        Query query = entityManager.createQuery
                ("FROM Employee WHERE lastName = :lastName", Employee.class);

       List<Employee> list =  query.setParameter("lastName",lastName)
               .getResultList();

       list.forEach(e-> e.setAddress(address));

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

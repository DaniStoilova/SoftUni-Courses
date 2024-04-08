import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class RemoveTowns {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String townName = scanner.nextLine();

        EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();

        Town town = entityManager.createQuery
                 ("SELECT t FROM Town AS t WHERE t.name = :townName", Town.class)
                .setParameter("townName", townName)
                .getSingleResult();

        List<Address> addresses = entityManager
                .createQuery
               ("SELECT a FROM Address AS a WHERE a.town.name = :townName", Address.class)
                .setParameter("townName", townName)
                .getResultList();


        for (Address address : addresses) {
            for (Employee employee : address.getEmployees()) {
                employee.setAddress(null);
            }
            address.setTown(null);
            entityManager.remove(address);
        }

        String result = String.format("%d address%s in %s deleted%n",
                addresses.size(), (addresses.size() != 1) ? "es" : "", town.getName());

        entityManager.remove(town);

        entityManager.getTransaction().commit();

        System.out.println(result);

        entityManager.close();

    }
}

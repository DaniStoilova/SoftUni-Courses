import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AddressesWithEmployeeCount {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery
                ("FROM Address ORDER BY employees.size DESC", Address.class);

         query.setMaxResults(10).getResultList()
                 .forEach(System.out::println);




        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

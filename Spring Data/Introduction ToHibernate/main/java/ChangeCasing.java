import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ChangeCasing {
    public static void main(String[] args) {

        EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();

       Query query =  entityManager.createQuery("FROM Town", Town.class);

        List<Town> townList = query.getResultList();

        for (Town town : townList) {
            String townName = town.getName();
            if (town.getName().length() <= 5){
                town.setName(townName.toUpperCase());
                entityManager.persist(town);

            }
        }
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}

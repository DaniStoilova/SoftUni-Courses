import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Comparator;
import java.util.List;

public class FindTheLatest10Projects {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("FROM Project ORDER BY startDate DESC, name", Project.class);

        List<Project> projectList = query.setMaxResults(10).getResultList();

        projectList.stream().sorted(Comparator.comparing(Project::getName))
                .forEach(System.out::println);






        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

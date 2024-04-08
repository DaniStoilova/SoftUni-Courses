package hiberspring.repository;

import hiberspring.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "SELECT concat(e.first_name,' ',e.last_name)as full_name , length(e.position)\n" +
            " FROM employees as e \n" +
            " join branches as b on b.id = e.branch_id\n" +
            " join products as p on p.branch_id = b.id\n" +
            " group by (e.id)\n" +
            " having count(p.branch_id) = 1\n" +
            " order by full_name Asc, e.position Desc;",nativeQuery = true)
    List<Employee> findAll();

    ;

}

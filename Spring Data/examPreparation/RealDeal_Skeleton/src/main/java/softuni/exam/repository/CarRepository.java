package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Car;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    Optional<Car> findFirstByMake(String make);

    @Query("SELECT c FROM Car c ORDER by size(c.pictures) Desc ,c.make ASC")
    List<Car> findAll();


}

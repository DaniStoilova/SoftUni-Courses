package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DayOfWeek;
import softuni.exam.models.entity.Forecast;

import java.util.Optional;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast,Long> {


   Optional<Forecast>findAllByCityIdAndDayOfWeek(Long id,DayOfWeek dayOfWeek);

}

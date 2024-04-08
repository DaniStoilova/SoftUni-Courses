package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Position;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

    Optional<Player> findFirstByPosition(Position position);

    List<Player> findPlayersBySalaryGreaterThanOrderBySalaryDesc(BigDecimal salary);

    List<Player>  findAllByTeamNameOrderById(String name);

}

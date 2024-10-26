package doubleplay.playbaseball.view.domain.team.repository;

import doubleplay.playbaseball.entities.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}

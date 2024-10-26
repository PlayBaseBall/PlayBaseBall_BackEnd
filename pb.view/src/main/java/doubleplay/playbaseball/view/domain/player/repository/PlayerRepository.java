package doubleplay.playbaseball.view.domain.player.repository;

import doubleplay.playbaseball.entities.players.Players;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Players, Long> {
}

package repository;

import model.Challenge;
import model.Player;
import model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findAll();
    Optional<Recipe> findById(Long id);

    List<Challenge> findAllChallenges();
    Challenge findChallengeById(Long id);

    boolean savePlayerProgress(Player player);
}

package repository;

import model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    // Puedes definir métodos de consulta personalizados aquí, si es necesario.
    // Ejemplo: Optional<Challenge> findByName(String name);

    // Optional es una forma de manejar los valores nulos de forma segura, evitando los NullPointerException
    Optional<Challenge> findByName(String name);
}

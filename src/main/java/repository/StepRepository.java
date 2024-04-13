package repository;

import model.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends JpaRepository<Step, Long> {
    // Puedes definir métodos de consulta adicionales aquí si los necesitas
}

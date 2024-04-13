package repository;

import model.SolidIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolidIngredientRepository extends JpaRepository<SolidIngredient, Long> {
    // Puedes definir métodos de consulta adicionales aquí si los necesitas
}

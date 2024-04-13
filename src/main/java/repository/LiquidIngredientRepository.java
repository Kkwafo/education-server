package repository;

import model.LiquidIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiquidIngredientRepository extends JpaRepository<LiquidIngredient, Long> {
    // Puedes definir métodos de consulta adicionales aquí si los necesitas
}

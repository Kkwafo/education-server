
package repository;

import model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
    // Métodos de consulta personalizados aquí si los necesitas
}
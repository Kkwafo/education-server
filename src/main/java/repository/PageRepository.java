package repository;

import model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
    // JpaRepository<Page, Long> maneja operaciones CRUD básicas
    // Puedes agregar métodos de consulta personalizados aquí si es necesario
}

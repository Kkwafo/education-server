package repository;

import model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // JpaRepository<Book, Long> maneja operaciones CRUD básicas
    // Puedes agregar métodos de consulta personalizados aquí si es necesario
}

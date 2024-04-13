package services.impl;

import model.Book;
import model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookRepository;
import repository.PageRepository;
import services.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl  implements BookService {

    private final BookRepository bookRepository;
    private final PageRepository pageRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, PageRepository pageRepository) {
        this.bookRepository = bookRepository;
        this.pageRepository = pageRepository;
    }

    // Obtener todos los libros
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Obtener un libro por ID
    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    // Crear un nuevo libro
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Actualizar un libro existente por ID
    public Book updateBook(Long id, Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setBookName(updatedBook.getBookName());
            // Si es necesario, puedes agregar lógica adicional aquí para actualizar otros atributos del libro
            return bookRepository.save(existingBook);
        } else {
            return null;
        }
    }

    // Eliminar un libro por ID
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // Obtener todas las páginas de un libro por ID del libro
    public List<Page> getPagesByBookId(Long bookId) {
        Book book = getBookById(bookId);
        if (book != null) {
            return book.getPages();
        } else {
            return null;
        }
    }
}

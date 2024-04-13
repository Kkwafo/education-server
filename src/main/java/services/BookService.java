package services;

import model.Book;
import model.Page;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book createBook(Book book);

    Book updateBook(Long id, Book updatedBook);

    boolean deleteBook(Long id);

    List<Page> getPagesByBookId(Long id);
}

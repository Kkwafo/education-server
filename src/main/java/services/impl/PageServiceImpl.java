package services.impl;

import model.Page;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PageRepository;
import repository.BookRepository;

import java.util.List;

@Service
public class PageServiceImpl {

    private final PageRepository pageRepository;
    private final BookRepository bookRepository;

    @Autowired
    public PageServiceImpl(PageRepository pageRepository, BookRepository bookRepository) {
        this.pageRepository = pageRepository;
        this.bookRepository = bookRepository;
    }

    // Obtener todas las páginas
    public List<Page> getAllPages() {
        return pageRepository.findAll();
    }

    // Obtener una página por ID
    public Page getPageById(Long id) {
        return pageRepository.findById(id).orElse(null);
    }

    // Crear una nueva página
    public Page createPage(Page page, Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null) {
            page.setBook(book);
            return pageRepository.save(page);
        } else {
            return null; // No se encontró el libro
        }
    }

    // Actualizar una página existente por ID
    public Page updatePage(Long id, Page updatedPage) {
        Page existingPage = pageRepository.findById(id).orElse(null);
        if (existingPage != null) {
            existingPage.setContent(updatedPage.getContent());
            // Puedes agregar lógica adicional para actualizar otros atributos de la página
            return pageRepository.save(existingPage);
        } else {
            return null;
        }
    }

    // Eliminar una página por ID
    public boolean deletePage(Long id) {
        if (pageRepository.existsById(id)) {
            pageRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

package controllers;

import model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.impl.PageServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/pages")
public class PageController {

    private final PageServiceImpl pageService;

    @Autowired
    public PageController(PageServiceImpl pageService) {
        this.pageService = pageService;
    }

    // Obtener todas las páginas
    @GetMapping
    public ResponseEntity<List<Page>> getAllPages() {
        List<Page> pages = pageService.getAllPages();
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }

    // Obtener una página por ID
    @GetMapping("/{id}")
    public ResponseEntity<Page> getPageById(@PathVariable Long id) {
        Page page = pageService.getPageById(id);
        if (page != null) {
            return new ResponseEntity<>(page, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva página
    @PostMapping
    public ResponseEntity<Page> createPage(@RequestBody Page page, @RequestParam Long bookId) {
        Page newPage = pageService.createPage(page, bookId);
        if (newPage != null) {
            return new ResponseEntity<>(newPage, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Actualizar una página existente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Page> updatePage(@PathVariable Long id, @RequestBody Page updatedPage) {
        Page page = pageService.updatePage(id, updatedPage);
        if (page != null) {
            return new ResponseEntity<>(page, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una página por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePage(@PathVariable Long id) {
        boolean deleted = pageService.deletePage(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

package services;

import model.Page;

import java.util.List;

public interface PageService {
    List<Page> getAllPages();

    Page getPageById(Long id);

    Page createPage(Page page);

    Page updatePage(Long id, Page updatedPage);

    boolean deletePage(Long id);

    List<Page> getPagesByBookId(Long bookId);
}

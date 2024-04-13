package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Page> pages = new ArrayList<>();

    public Book() {
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void addPage(Page page) {
        page.setBook(this);
        pages.add(page);
    }

    public void removePage(Page page) {
        page.setBook(null);
        pages.remove(page);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", pages=" + pages +
                '}';
    }
}

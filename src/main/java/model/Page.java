package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    public Page() {
    }

    public Page(List<String> content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", content=" + content +
                ", book=" + (book != null ? book.getBookName() : "null") +
                '}';
    }
}

package ucb.edu.bo.project.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name = "book")
@NamedQueries({
        @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
        @NamedQuery(name = "Book.findByBookId", query = "SELECT b FROM Book b WHERE b.bookId = :bookId"),
        @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
        @NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author"),
        @NamedQuery(name = "Book.findByCategory", query = "SELECT b FROM Book b WHERE b.category = :category")})

public class Book implements Serializable  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "title")
    private String title;
    @Column(name = "release_date")
    private String releaseDate;
    @Column(name = "author")
    private String author;
    @Column(name = "category")
    private String category;
    @Column(name = "editorial")
    private String editorial;
    @Column(name = "language")
    private String language;
    @Column(name = "pages")
    private Integer pages;
    @Column(name = "description")
    private String description;
    @Column(name = "book_cover")
    private String bookCover;

    public Book() {
    }

    public Book(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBookId() {
        return this.bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getEditorial() {
        return this.editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookCover() {
        return this.bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) && Objects.equals(title, book.title) && Objects.equals(releaseDate, book.releaseDate) && Objects.equals(author, book.author) && Objects.equals(category, book.category) && Objects.equals(editorial, book.editorial) && Objects.equals(language, book.language) && Objects.equals(pages, book.pages) && Objects.equals(description, book.description) && Objects.equals(bookCover, book.bookCover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, releaseDate, author, category, editorial, language, pages, description, bookCover);
    }


    @Override
    public String toString() {
        return "Book{" +
            " bookId='" + bookId + 
            ", title='" + title + '\'' +
            ", releaseDate='" + releaseDate + '\'' +
            ", author='" + author + '\'' +
            ", category='" + category + '\'' +
            ", editorial='" + editorial + '\'' +
            ", language='" + language + '\'' +
            ", pages='" + pages + '\'' +
            ", description='" + description + '\'' +
            ", bookCover='" + bookCover + '\'' +
            '}';
    }


}

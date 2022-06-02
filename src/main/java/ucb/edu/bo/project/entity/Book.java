package ucb.edu.bo.project.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "book")
@SQLDelete(sql = "UPDATE book SET status=0 WHERE id=?")
@NamedQueries({
        @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
        @NamedQuery(name = "Book.findByBookId", query = "SELECT b FROM Book b WHERE b.bookId = :bookId"),
        @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
        @NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.authorId = :authorId")})

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
    private Date releaseDate;
    @Basic
    @Column(name = "author_id")
    private int authorId;
    @Basic
    @Column(name = "editorial_id")
    private int editorialId;
    @Column(name = "language")
    private String language;
    @Column(name = "pages")
    private Integer pages;
    @Column(name = "description")
    private String description;
    @Column(name = "book_cover")
    private String bookCover;
    @Column(name = "stock")
    private int stock;
    @Column(name = "status")
    private Integer status;
    @OneToMany(mappedBy = "bookId", fetch = FetchType.LAZY)
    private List<BookCategory> BookcategoryList;

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

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }


    public int getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
   

    public int getEditorialId() {
        return this.editorialId;
    }

    public void setEditorialId(int editorialId) {
        this.editorialId = editorialId;
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

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) && Objects.equals(title, book.title) && Objects.equals(releaseDate, book.releaseDate) && authorId == book.authorId && editorialId == book.editorialId && Objects.equals(language, book.language) && Objects.equals(pages, book.pages) && Objects.equals(description, book.description) && Objects.equals(bookCover, book.bookCover) && Objects.equals(stock, book.stock) && Objects.equals(status, book.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, releaseDate, authorId, editorialId, language, pages, description, bookCover, stock, status);
    }
    

    @Override
    public String toString() {
        return "Book{" +
            " bookId='" + bookId + 
            ", title='" + title + '\'' +
            ", releaseDate='" + releaseDate + '\'' +
            ", authorId='" + authorId + '\'' +
            ", editorialId='" + editorialId + '\'' +
            ", language='" + language + '\'' +
            ", pages='" + pages + '\'' +
            ", description='" + description + '\'' +
            ", bookCover='" + bookCover + '\'' +
            ", stock='" + stock + '\'' +
            ", status='" + status + '\'' +
            '}';
    }


}

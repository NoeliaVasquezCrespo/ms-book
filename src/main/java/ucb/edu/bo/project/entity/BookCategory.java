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
@Table(name = "book_category")
@NamedQueries({
        @NamedQuery(name = "BookCategory.findAll", query = "SELECT bc FROM BookCategory bc"),
        @NamedQuery(name = "BookCategory.findByBookId", query = "SELECT bc FROM BookCategory bc WHERE bc.bookId = :bookId")})

public class BookCategory implements Serializable  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "book_category_id")
    private Integer bookcategoryId;
    @Basic
    @Column(name = "book_id")
    private int bookId;
    @Basic
    @Column(name = "category_id")
    private int categoryId;


    public BookCategory() {
    }

    
    public Integer getBookcategoryId() {
        return this.bookcategoryId;
    }

    public void setBookcategoryId(Integer bookcategoryId) {
        this.bookcategoryId = bookcategoryId;
    }

    public int getBookId() {
        return this.bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public BookCategory bookcategoryId(Integer bookcategoryId) {
        setBookcategoryId(bookcategoryId);
        return this;
    }

    public BookCategory bookId(int bookId) {
        setBookId(bookId);
        return this;
    }

    public BookCategory categoryId(int categoryId) {
        setCategoryId(categoryId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BookCategory)) {
            return false;
        }
        BookCategory bookCategory = (BookCategory) o;
        return Objects.equals(bookcategoryId, bookCategory.bookcategoryId) && bookId == bookCategory.bookId && categoryId == bookCategory.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookcategoryId, bookId, categoryId);
    }

    @Override
    public String toString() {
        return "BookCategory {" +
            " bookcategoryId='" + bookcategoryId +
            ", bookId='" + bookId +  '\'' +
            ", categoryId='" + categoryId + '\'' +
            '}';
    }

    
}

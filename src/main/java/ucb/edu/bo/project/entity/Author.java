package ucb.edu.bo.project.entity;

import java.io.Serializable;
import java.util.List;
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


@Entity
@Table(name = "author")
@NamedQueries({
        @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
        @NamedQuery(name = "Author.findByAuthorId", query = "SELECT a FROM Author a WHERE a.authorId = :authorId"),
        @NamedQuery(name = "Author.findByName", query = "SELECT a FROM Author a WHERE a.name = :name")})

public class Author implements Serializable  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "authorId", fetch = FetchType.LAZY)
    private List<Book> authorBookList;
    
     public Author() {
    }

    public Author(Integer authorId) {
        this.authorId = authorId;
    }
    
    public Integer getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Author)) {
            return false;
        }
        Author author = (Author) o;
        return Objects.equals(authorId, author.authorId) && Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, name);
    }


    @Override
    public String toString() {
        return "Author{" +
            " authorId='" + authorId +
            ", name='" + name + '\'' +
            '}';
    }


}

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
@Table(name = "editorial")
@NamedQueries({
        @NamedQuery(name = "Editorial.findAll", query = "SELECT e FROM Editorial e"),
        @NamedQuery(name = "Editorial.findByEditorialId", query = "SELECT e FROM Editorial e WHERE e.editorialId = :editorialId"),
        @NamedQuery(name = "Editorial.findByEditorial", query = "SELECT e FROM Editorial e WHERE e.editorial = :editorial")})

public class Editorial implements Serializable  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "editorial_id")
    private Integer editorialId;
    @Column(name = "editorial")
    private String editorial;
    @OneToMany(mappedBy = "editorialId", fetch = FetchType.LAZY)
    private List<Book> editorialBookList;


    public Editorial() {
    }

    public Editorial(Integer editorialId) {
        this.editorialId = editorialId;
    }

    public Integer getEditorialId() {
        return this.editorialId;
    }

    public void setEditorialId(Integer editorialId) {
        this.editorialId = editorialId;
    }

    public String getEditorial() {
        return this.editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Editorial editorialId(Integer editorialId) {
        setEditorialId(editorialId);
        return this;
    }

    public Editorial editorial(String editorial) {
        setEditorial(editorial);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Editorial)) {
            return false;
        }
        Editorial editorial = (Editorial) o;
        return Objects.equals(editorialId, editorial.editorialId) && Objects.equals(editorial, editorial.editorial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(editorialId, editorial);
    }

    @Override
    public String toString() {
        return "Editorial{" +
            " editorialId='" + editorialId +
            ", editorial='" + editorial + '\'' +
            '}';
    }

    
}

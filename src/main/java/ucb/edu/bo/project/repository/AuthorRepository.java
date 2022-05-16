package ucb.edu.bo.project.repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;
import ucb.edu.bo.project.entity.Author;

import java.util.List;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Integer> {

    @Query(value="SELECT * FROM author", nativeQuery = true)
    List<Author> getAuthors();

    @Query(value = "SELECT a FROM Author a")
    List<Author> getAuthorsJPA();

    @Query(value = "SELECT a FROM Author a WHERE a.authorId = :id")
    Author getAuthorByIdJPA(Long id);

    @Query(value = "SELECT * FROM author a WHERE a.author_id = :id", nativeQuery = true)
    Author getAuthorById(Long id);
    
}

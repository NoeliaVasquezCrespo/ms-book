package ucb.edu.bo.project.repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;
import ucb.edu.bo.project.entity.Editorial;

import java.util.List;

public interface EditorialRepository extends PagingAndSortingRepository<Editorial, Integer> {

    @Query(value="SELECT * FROM editorial", nativeQuery = true)
    List<Editorial> getEditorials();

    @Query(value = "SELECT e FROM Editorial e")
    List<Editorial> getEditorialsJPA();

    @Query(value = "SELECT e FROM Editorial e WHERE e.editorialId = :id")
    Editorial getEditorialByIdJPA(Long id);

    @Query(value = "SELECT * FROM editorial e WHERE e.editorial_id = :id", nativeQuery = true)
    Editorial getEditorialById(Long id);
    
}

package ucb.edu.bo.project.repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;
import ucb.edu.bo.project.entity.Category;

import java.util.List;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {

    @Query(value="SELECT * FROM category", nativeQuery = true)
    List<Category> getCategorys();

    @Query(value = "SELECT c FROM Category c")
    List<Category> getCategorysJPA();

    @Query(value = "SELECT c FROM Category c WHERE c.categoryId = :id")
    Category getCategoryByIdJPA(Long id);

    @Query(value = "SELECT * FROM category c WHERE c.category_id = :id", nativeQuery = true)
    Category getCategoryById(Long id);
    
}

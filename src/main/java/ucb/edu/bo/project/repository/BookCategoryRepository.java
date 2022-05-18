package ucb.edu.bo.project.repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;
import ucb.edu.bo.project.entity.BookCategory;

import java.util.List;
public interface BookCategoryRepository extends PagingAndSortingRepository<BookCategory, Integer> {

    @Query(value="SELECT * FROM book_category", nativeQuery = true)
    List<BookCategory> getBookCategorys();

    @Query(value = "SELECT * FROM book_category bc WHERE bc.book_category_id = :id", nativeQuery = true)
    BookCategory getBookCategoryById(Long id);
    
}

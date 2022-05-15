package ucb.edu.bo.project.repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;
import ucb.edu.bo.project.entity.Book;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {

    @Query(value="SELECT * FROM book", nativeQuery = true)
    List<Book> getBooks();

    @Query(value = "SELECT b FROM Book b")
    List<Book> getBooksJPA();

    @Query(value = "SELECT b FROM Book b WHERE b.bookId = :id")
    Book getBookByIdJPA(Long id);

    @Query(value = "SELECT * FROM book b WHERE b.book_id = :id", nativeQuery = true)
    Book getBookById(Long id);

 
    
}

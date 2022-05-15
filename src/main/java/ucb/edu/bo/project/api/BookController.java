package ucb.edu.bo.project.api;

import ucb.edu.bo.project.bl.BookBl;
import ucb.edu.bo.project.dto.BookDto;
import ucb.edu.bo.project.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/books")
public class BookController {
    private static Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    private BookBl bookBl;

    @Value("${key}")
    String key;

    @Autowired
    public BookController(BookBl bookBl) {
        this.bookBl = bookBl;
    }

    @RequestMapping(value = "/paginate", method = RequestMethod.GET)
    public ResponseEntity<PageImpl<BookDto>> getBooksPaginate(
            @RequestParam Integer page,
            @RequestParam Integer size
    ) {
        LOGGER.info("Invocando al servicio REST para obtener el listado de libros con KEY: {}", key);
        PageImpl<BookDto> bookList = bookBl.getBooksPaginate(page, size);
        LOGGER.info("Invocacion exitosa para obtener el listado de libros {}", bookList);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks() {
        LOGGER.info("Invocando al servicio REST para obtener el listado de libros con KEY: {}", key);
        List<Book> bookList = bookBl.getBooks();
        LOGGER.info("Invocacion exitosa para obtener el listado de libros {}", bookList);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBooksById(@PathVariable Long id) {
        LOGGER.info("Invocando al servicio REST para obtener el estudiante con id: {}", id);
        Book book = bookBl.getBookById(id);
        LOGGER.info("Invocacion exitosa para obtener el libros {}", book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        LOGGER.info("Invocando al servicio REST para registrar un estudiante con la siguiente información: {}", book);
        Book result = bookBl.saveBook(book);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
}

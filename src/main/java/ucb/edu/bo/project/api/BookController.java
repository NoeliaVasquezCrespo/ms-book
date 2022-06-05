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
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/v1/api/books")
public class BookController {
    private static Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    private BookBl bookBl;

    @Value("${server.port}")
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
        LOGGER.info("Invocando al servicio REST para obtener el listado de libros en el PUERTO: {}", key);
        PageImpl<BookDto> bookList = bookBl.getBooksPaginate(page, size);
        LOGGER.info("Invocacion exitosa para obtener el listado de libros {}", bookList);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks() {
        LOGGER.info("Invocando al servicio REST para obtener el listado de libros al ms LOANS SERVICE", key);
        List<Book> bookList = bookBl.getBooks();
      //  LOGGER.info("Invocacion exitosa para obtener el listado de libros {}", bookList);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBooksById(@PathVariable Integer id) {
        LOGGER.info("Invocando al servicio REST para obtener el libro con id: {}", id);
        Book book = bookBl.getBookById(id);
        LOGGER.info("Invocacion exitosa para obtener el libros {}", book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Book> saveBook(@RequestBody BookDto book) {
        LOGGER.info("Invocando al servicio REST para registrar un libro con la siguiente información: {}", book);
        Book result = bookBl.saveBook(book);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    

    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
        boolean result = this.bookBl.deleteBook(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
        
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book book) {
        LOGGER.info("Invocando al servicio REST para editar el libro con id: {}", id);
        book = bookBl.updateBook(id, book);
        LOGGER.info("Invocacion exitosa para obtener el libros {}", book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @RequestMapping(path = "/status/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateStatusBook(@PathVariable Integer id) {
        boolean result = this.bookBl.updateStatusBook(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/list/{status}", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooksByStatus(@PathVariable Integer status) {
        LOGGER.info("Invocando al servicio REST para obtener el libro con status: {}", status);
        List<Book> book = bookBl.getBookByStatus(status);
        LOGGER.info("Invocacion exitosa para obtener el libros {}", book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

}

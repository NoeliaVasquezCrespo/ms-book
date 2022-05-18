package ucb.edu.bo.project.api;

import ucb.edu.bo.project.bl.BookCategoryBl;
import ucb.edu.bo.project.dto.BookCategoryDto;
import ucb.edu.bo.project.entity.BookCategory;
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
@RequestMapping("/v1/api/book/category")
public class BookCategoryController {
    private static Logger LOGGER = LoggerFactory.getLogger(BookCategoryController.class);

    private BookCategoryBl bookcategoryBl;

    @Value("${key}")
    String key;

    @Autowired
    public BookCategoryController(BookCategoryBl bookcategoryBl) {
        this.bookcategoryBl = bookcategoryBl;
    }

    @RequestMapping(value = "/paginate", method = RequestMethod.GET)
    public ResponseEntity<PageImpl<BookCategoryDto>> getBookCategorysPaginate(
            @RequestParam Integer page,
            @RequestParam Integer size
    ) {
        LOGGER.info("Invocando al servicio REST para obtener el listado de autores con KEY: {}", key);
        PageImpl<BookCategoryDto> bookcategoryList = bookcategoryBl.getBookCategorysPaginate(page, size);
        LOGGER.info("Invocacion exitosa para obtener el listado de autores {}", bookcategoryList);
        return new ResponseEntity<>(bookcategoryList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BookCategory>> getBookCategorys() {
        LOGGER.info("Invocando al servicio REST para obtener el listado de autores con KEY: {}", key);
        List<BookCategory> bookcategoryList = bookcategoryBl.getBookCategorys();
        LOGGER.info("Invocacion exitosa para obtener el listado de autores {}", bookcategoryList);
        return new ResponseEntity<>(bookcategoryList, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<BookCategory> getBookCategorysById(@PathVariable Long id) {
        LOGGER.info("Invocando al servicio REST para obtener el autor con id: {}", id);
        BookCategory bookcategory = bookcategoryBl.getBookCategoryById(id);
        LOGGER.info("Invocacion exitosa para obtener el autores {}", bookcategory);
        return new ResponseEntity<>(bookcategory, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<BookCategory> saveBookCategory(@RequestBody BookCategory bookcategory) {
        LOGGER.info("Invocando al servicio REST para registrar un autor con la siguiente información: {}", bookcategory);
        BookCategory result = bookcategoryBl.saveBookCategory(bookcategory);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

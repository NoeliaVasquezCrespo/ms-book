package ucb.edu.bo.project.api;

import ucb.edu.bo.project.bl.AuthorBl;
import ucb.edu.bo.project.dto.AuthorDto;
import ucb.edu.bo.project.entity.Author;
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
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/v1/api/authors")
public class AuthorController {
    private static Logger LOGGER = LoggerFactory.getLogger(AuthorController.class);

    private AuthorBl authorBl;

    @Value("${key}")
    String key;

    @Autowired
    public AuthorController(AuthorBl authorBl) {
        this.authorBl = authorBl;
    }

    @RequestMapping(value = "/paginate", method = RequestMethod.GET)
    public ResponseEntity<PageImpl<AuthorDto>> getAuthorsPaginate(
            @RequestParam Integer page,
            @RequestParam Integer size
    ) {
        LOGGER.info("Invocando al servicio REST para obtener el listado de autores con KEY: {}", key);
        PageImpl<AuthorDto> authorList = authorBl.getAuthorsPaginate(page, size);
        LOGGER.info("Invocacion exitosa para obtener el listado de autores {}", authorList);
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Author>> getAuthors() {
        LOGGER.info("Invocando al servicio REST para obtener el listado de autores con KEY: {}", key);
        List<Author> authorList = authorBl.getAuthors();
        LOGGER.info("Invocacion exitosa para obtener el listado de autores {}", authorList);
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Author> getAuthorsById(@PathVariable Long id) {
        LOGGER.info("Invocando al servicio REST para obtener el autor con id: {}", id);
        Author author = authorBl.getAuthorById(id);
        LOGGER.info("Invocacion exitosa para obtener el autores {}", author);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author) {
        LOGGER.info("Invocando al servicio REST para registrar un autor con la siguiente información: {}", author);
        Author result = authorBl.saveAuthor(author);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    
}

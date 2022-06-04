package ucb.edu.bo.project.api;

import ucb.edu.bo.project.bl.EditorialBl;
import ucb.edu.bo.project.dto.EditorialDto;
import ucb.edu.bo.project.entity.Editorial;
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
@RequestMapping("/v1/api/editorial")
public class EditorialController {
    private static Logger LOGGER = LoggerFactory.getLogger(EditorialController.class);

    private EditorialBl editorialBl;

    @Value("${key}")
    String key;

    @Autowired
    public EditorialController(EditorialBl editorialBl) {
        this.editorialBl = editorialBl;
    }

    @RequestMapping(value = "/paginate", method = RequestMethod.GET)
    public ResponseEntity<PageImpl<EditorialDto>> getEditorialsPaginate(
            @RequestParam Integer page,
            @RequestParam Integer size
    ) {
        LOGGER.info("Invocando al servicio REST para obtener el listado de editoriales con KEY: {}", key);
        PageImpl<EditorialDto> editorialList = editorialBl.getEditorialsPaginate(page, size);
        LOGGER.info("Invocacion exitosa para obtener el listado de editoriales {}", editorialList);
        return new ResponseEntity<>(editorialList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Editorial>> getEditorials() {
        LOGGER.info("Invocando al servicio REST para obtener el listado de editoriales con KEY: {}", key);
        List<Editorial> editorialList = editorialBl.getEditorials();
        LOGGER.info("Invocacion exitosa para obtener el listado de editoriales {}", editorialList);
        return new ResponseEntity<>(editorialList, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Editorial> getEditorialsById(@PathVariable Long id) {
        LOGGER.info("Invocando al servicio REST para obtener el editorial con id: {}", id);
        Editorial editorial = editorialBl.getEditorialById(id);
        LOGGER.info("Invocacion exitosa para obtener el editoriales {}", editorial);
        return new ResponseEntity<>(editorial, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Editorial> saveEditorial(@RequestBody Editorial editorial) {
        LOGGER.info("Invocando al servicio REST para registrar un editorial con la siguiente información: {}", editorial);
        Editorial result = editorialBl.saveEditorial(editorial);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

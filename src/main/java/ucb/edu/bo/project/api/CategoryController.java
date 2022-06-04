package ucb.edu.bo.project.api;

import ucb.edu.bo.project.bl.CategoryBl;
import ucb.edu.bo.project.dto.CategoryDto;
import ucb.edu.bo.project.entity.Category;
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
@RequestMapping("/v1/api/categories")
public class CategoryController {
    private static Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    private CategoryBl categoryBl;

    @Value("${key}")
    String key;

    @Autowired
    public CategoryController(CategoryBl categoryBl) {
        this.categoryBl = categoryBl;
    }

    @RequestMapping(value = "/paginate", method = RequestMethod.GET)
    public ResponseEntity<PageImpl<CategoryDto>> getCategorysPaginate(
            @RequestParam Integer page,
            @RequestParam Integer size
    ) {
        LOGGER.info("Invocando al servicio REST para obtener el listado de categorias con KEY: {}", key);
        PageImpl<CategoryDto> categoryList = categoryBl.getCategorysPaginate(page, size);
        LOGGER.info("Invocacion exitosa para obtener el listado de categorias {}", categoryList);
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategorys() {
        LOGGER.info("Invocando al servicio REST para obtener el listado de categorias con KEY: {}", key);
        List<Category> categoryList = categoryBl.getCategorys();
        LOGGER.info("Invocacion exitosa para obtener el listado de categorias {}", categoryList);
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getCategorysById(@PathVariable Long id) {
        LOGGER.info("Invocando al servicio REST para obtener el categoria con id: {}", id);
        Category category = categoryBl.getCategoryById(id);
        LOGGER.info("Invocacion exitosa para obtener el categorias {}", category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        LOGGER.info("Invocando al servicio REST para registrar un categoria con la siguiente información: {}", category);
        Category result = categoryBl.saveCategory(category);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

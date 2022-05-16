package ucb.edu.bo.project.bl;

import ucb.edu.bo.project.dto.CategoryDto;
import ucb.edu.bo.project.entity.Category;
import ucb.edu.bo.project.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryBl {
    
    private static Logger LOGGER = LoggerFactory.getLogger(CategoryBl.class);
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryBl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public PageImpl<CategoryDto> getCategorysPaginate(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("categoryId").ascending());
        LOGGER.info("DATABASE: Iniciando consulta para obtener los categorias");
        Page<Category> pageCategory = categoryRepository.findAll(pageable);
        List<CategoryDto> categoryList = pageCategory.stream()
                .map(CategoryDto::new)
                .collect(Collectors.toList());
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener el listado de categorias {}", categoryList);
        return new PageImpl<>(categoryList, pageable, pageCategory.getTotalElements());
    }

    public List<Category> getCategorys() {
        LOGGER.info("DATABASE: Iniciando consulta para obtener los categorias");
        List<Category> categoryList = (List<Category>) categoryRepository.findAll();
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener el listado de categorias {}", categoryList);
        return categoryList;
    }

    public Category getCategoryById(Long id) {
        LOGGER.info("DATABASE: Iniciando consulta para obtener categoria con id: {}", id);
        Category category = categoryRepository.getCategoryById(id);
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener categoria con id:{}, retorno {}", id, category);
        return category;
    }

    public Category saveCategory(Category category) {
        LOGGER.info("DATABASE: Iniciando consulta para guardar categoria con la siguiente información: {}", category);
        Category result = categoryRepository.save(category);
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para guardar categoria retorno {}", result);
        return result;
    }
}

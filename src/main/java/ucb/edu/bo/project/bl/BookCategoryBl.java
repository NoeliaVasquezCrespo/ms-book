package ucb.edu.bo.project.bl;

import ucb.edu.bo.project.dto.BookCategoryDto;
import ucb.edu.bo.project.entity.BookCategory;
import ucb.edu.bo.project.repository.BookCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookCategoryBl {

    private static Logger LOGGER = LoggerFactory.getLogger(BookCategoryBl.class);
    private BookCategoryRepository bookcategoryRepository;

    @Autowired
    public BookCategoryBl(BookCategoryRepository bookcategoryRepository) {
        this.bookcategoryRepository = bookcategoryRepository;
    }

    public PageImpl<BookCategoryDto> getBookCategorysPaginate(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("bookcategoryId").ascending());
        LOGGER.info("DATABASE: Iniciando consulta para obtener los autores");
        Page<BookCategory> pageBookCategory = bookcategoryRepository.findAll(pageable);
        List<BookCategoryDto> bookcategoryList = pageBookCategory.stream()
                .map(BookCategoryDto::new)
                .collect(Collectors.toList());
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener el listado de autores {}", bookcategoryList);
        return new PageImpl<>(bookcategoryList, pageable, pageBookCategory.getTotalElements());
    }

    public List<BookCategory> getBookCategorys() {
        LOGGER.info("DATABASE: Iniciando consulta para obtener los autores");
        List<BookCategory> bookcategoryList = (List<BookCategory>) bookcategoryRepository.findAll();
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener el listado de autores {}", bookcategoryList);
        return bookcategoryList;
    }

    public BookCategory getBookCategoryById(Long id) {
        LOGGER.info("DATABASE: Iniciando consulta para obtener autor con id: {}", id);
        BookCategory bookcategory = bookcategoryRepository.getBookCategoryById(id);
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener autor con id:{}, retorno {}", id, bookcategory);
        return bookcategory;
    }

    public BookCategory saveBookCategory(BookCategory bookcategory) {
        LOGGER.info("DATABASE: Iniciando consulta para guardar autor con la siguiente información: {}", bookcategory);
        BookCategory result = bookcategoryRepository.save(bookcategory);
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para guardar autor retorno {}", result);
        return result;
    }

    
}

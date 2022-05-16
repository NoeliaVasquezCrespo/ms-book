package ucb.edu.bo.project.bl;

import ucb.edu.bo.project.dto.EditorialDto;
import ucb.edu.bo.project.entity.Editorial;
import ucb.edu.bo.project.repository.EditorialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditorialBl {
    private static Logger LOGGER = LoggerFactory.getLogger(EditorialBl.class);
    private EditorialRepository editorialRepository;

    @Autowired
    public EditorialBl(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    public PageImpl<EditorialDto> getEditorialsPaginate(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("editorialId").ascending());
        LOGGER.info("DATABASE: Iniciando consulta para obtener los editoriales");
        Page<Editorial> pageEditorial = editorialRepository.findAll(pageable);
        List<EditorialDto> editorialList = pageEditorial.stream()
                .map(EditorialDto::new)
                .collect(Collectors.toList());
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener el listado de editoriales {}", editorialList);
        return new PageImpl<>(editorialList, pageable, pageEditorial.getTotalElements());
    }

    public List<Editorial> getEditorials() {
        LOGGER.info("DATABASE: Iniciando consulta para obtener los editoriales");
        List<Editorial> editorialList = (List<Editorial>) editorialRepository.findAll();
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener el listado de editoriales {}", editorialList);
        return editorialList;
    }

    public Editorial getEditorialById(Long id) {
        LOGGER.info("DATABASE: Iniciando consulta para obtener editorial con id: {}", id);
        Editorial editorial = editorialRepository.getEditorialById(id);
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener editorial con id:{}, retorno {}", id, editorial);
        return editorial;
    }

    public Editorial saveEditorial(Editorial editorial) {
        LOGGER.info("DATABASE: Iniciando consulta para guardar editorial con la siguiente información: {}", editorial);
        Editorial result = editorialRepository.save(editorial);
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para guardar editorial retorno {}", result);
        return result;
    }
}


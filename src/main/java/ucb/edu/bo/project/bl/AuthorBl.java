package ucb.edu.bo.project.bl;

import ucb.edu.bo.project.dto.AuthorDto;
import ucb.edu.bo.project.entity.Author;
import ucb.edu.bo.project.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorBl {

    private static Logger LOGGER = LoggerFactory.getLogger(AuthorBl.class);
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorBl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public PageImpl<AuthorDto> getAuthorsPaginate(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("authorId").ascending());
        LOGGER.info("DATABASE: Iniciando consulta para obtener los autores");
        Page<Author> pageAuthor = authorRepository.findAll(pageable);
        List<AuthorDto> authorList = pageAuthor.stream()
                .map(AuthorDto::new)
                .collect(Collectors.toList());
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener el listado de autores {}", authorList);
        return new PageImpl<>(authorList, pageable, pageAuthor.getTotalElements());
    }

    public List<Author> getAuthors() {
        LOGGER.info("DATABASE: Iniciando consulta para obtener los autores");
        List<Author> authorList = (List<Author>) authorRepository.findAll();
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener el listado de autores {}", authorList);
        return authorList;
    }

    public Author getAuthorById(Long id) {
        LOGGER.info("DATABASE: Iniciando consulta para obtener autor con id: {}", id);
        Author author = authorRepository.getAuthorById(id);
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener autor con id:{}, retorno {}", id, author);
        return author;
    }

    public Author saveAuthor(Author author) {
        LOGGER.info("DATABASE: Iniciando consulta para guardar autor con la siguiente información: {}", author);
        Author result = authorRepository.save(author);
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para guardar autor retorno {}", result);
        return result;
    }
}

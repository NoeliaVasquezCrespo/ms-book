package ucb.edu.bo.project.bl;

import ucb.edu.bo.project.dto.BookDto;
import ucb.edu.bo.project.entity.Book;
import ucb.edu.bo.project.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookBl {
    private static Logger LOGGER = LoggerFactory.getLogger(BookBl.class);
    private BookRepository bookRepository;

    @Autowired
    public BookBl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public PageImpl<BookDto> getBooksPaginate(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("bookId").ascending());
        LOGGER.info("DATABASE: Iniciando consulta para obtener los libros");
        Page<Book> pageBook = bookRepository.findAll(pageable);
        List<BookDto> bookList = pageBook.stream()
                .map(BookDto::new)
                .collect(Collectors.toList());
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener el listado de libros {}", bookList);
        return new PageImpl<>(bookList, pageable, pageBook.getTotalElements());
    }

    public List<Book> getBooks() {
        LOGGER.info("DATABASE: Iniciando consulta para obtener los libros");
        List<Book> bookList = (List<Book>) bookRepository.findAll();
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener el listado de libros {}", bookList);
        return bookList;
    }

    public Book getBookById(Long id) {
        LOGGER.info("DATABASE: Iniciando consulta para obtener estudiante con id: {}", id);
        Book book = bookRepository.getBookById(id);
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener estudiante con id:{}, retorno {}", id, book);
        return book;
    }

    public Book saveBook(Book book) {
        LOGGER.info("DATABASE: Iniciando consulta para guardar estudiante con la siguiente información: {}", book);
        Book result = bookRepository.save(book);
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para guardar estudiante retorno {}", result);
        return result;
    }

}

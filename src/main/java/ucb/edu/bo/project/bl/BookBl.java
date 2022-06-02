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
import java.util.Objects;
import java.util.Optional;
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
     //   LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener el listado de libros {}", bookList);
        return new PageImpl<>(bookList, pageable, pageBook.getTotalElements());
    }

    public List<Book> getBooks() {
    //    LOGGER.info("DATABASE: Iniciando consulta para obtener los libros");
        List<Book> bookList = (List<Book>) bookRepository.findAll();
     //   LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener el listado de libros {}", bookList);
        return bookList;
    }

    public Book getBookById(Integer id) {
        LOGGER.info("DATABASE: Iniciando consulta para obtener libro con id: {}", id);
        Book book = bookRepository.getBookById(id);
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener libro con id:{}, retorno {}", id, book);
        return book;
    }

    public Book saveBook(Book book) {
        LOGGER.info("DATABASE: Iniciando consulta para guardar libro con la siguiente información: {}", book);
        Book result = bookRepository.save(book);
        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para guardar libro retorno {}", result);
        return result;
    }

    public boolean deleteBook(Integer id){
        Optional<Book> optionalBook = this.bookRepository.findById(id);
        if(optionalBook.isPresent()){
            Book book = optionalBook.get();
            book.setStatus(0);
            this.bookRepository.save(book);
            return true;
        }else{
            return false;
        }
    }

    public Book updateBook(Integer id, Book book) {
        Book bookDB = bookRepository.getBookById(id);

        if (Objects.nonNull(book.getBookId())){
            bookDB.setBookId(book.getBookId());
        }
        if (Objects.nonNull(book.getTitle())){
            bookDB.setTitle(book.getTitle());
        }
        if (Objects.nonNull(book.getReleaseDate())){
            bookDB.setReleaseDate(book.getReleaseDate());
        }
        if (Objects.nonNull(book.getAuthorId())){
            bookDB.setAuthorId(book.getAuthorId());
        }
        if (Objects.nonNull(book.getEditorialId())){
            bookDB.setEditorialId(book.getEditorialId());
        }
        if (Objects.nonNull(book.getLanguage())){
            bookDB.setLanguage(book.getLanguage());
        }
        if (Objects.nonNull(book.getPages())){
            bookDB.setPages(book.getPages());
        }
        if (Objects.nonNull(book.getDescription())){
            bookDB.setDescription(book.getDescription());
        }
        if (Objects.nonNull(book.getBookCover())){
            bookDB.setBookCover(book.getBookCover());
        }
        if (Objects.nonNull(book.getStock())){
            bookDB.setStock(book.getStock());
        }

        if (Objects.nonNull(book.getStatus())){
            bookDB.setStatus(book.getStatus());
        }
        return bookRepository.save(bookDB);
    }

}

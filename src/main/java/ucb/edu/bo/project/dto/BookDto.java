package ucb.edu.bo.project.dto;

import java.util.Date;


import ucb.edu.bo.project.entity.Book;

public class BookDto {
    private Integer bookId;
    private String title;
    private Date releaseDate;
    private Integer authorId;
    private Integer editorialId;
    private String language;
    private Integer pages;
    private String description;
    private String bookCover;
    private Integer stock;
    private Integer status;


    public BookDto() {
    }

    public BookDto(Book book) {
        bookId = book.getBookId();
        title = book.getTitle();
        releaseDate = book.getReleaseDate();
        authorId = book.getAuthorId();
        editorialId = book.getEditorialId();
        language = book.getLanguage();
        pages = book.getPages();
        description = book.getDescription();
        bookCover = book.getBookCover();
        stock = book.getStock();
        status = book.getStatus();
    }

    public BookDto(Integer bookId, String title, Date releaseDate, Integer authorId,  Integer editorialId, String language, Integer pages, String description, String bookCover, Integer stock, Integer status) {
        this.bookId = bookId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.authorId = authorId;
        this.editorialId = editorialId;
        this.language = language;
        this.pages = pages;
        this.description = description;
        this.bookCover = bookCover;
        this.stock = stock;
        this.status = status;
    }

    public Integer getBookId() {
        return this.bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

   
    public Integer getEditorialId() {
        return this.editorialId;
    }

    public void setEditorialId(Integer editorialId) {
        this.editorialId = editorialId;
    }
    
    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookCover() {
        return this.bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "BookDto{" +
            " bookId='" + bookId + 
            ", title='" + title + '\'' +
            ", releaseDate='" + releaseDate + '\'' +
            ", authorId='" + authorId + '\'' +
            ", editorialId='" + editorialId + '\'' +
            ", language='" + language + '\'' +
            ", pages='" + pages + '\'' +
            ", description='" + description + '\'' +
            ", bookCover='" + bookCover + '\'' +
            ", stock='" + stock + '\'' +
            ", status='" + status + '\'' +
            '}';
    }

}

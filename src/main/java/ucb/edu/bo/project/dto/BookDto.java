package ucb.edu.bo.project.dto;

import ucb.edu.bo.project.entity.Book;

public class BookDto {
    private Integer bookId;
    private String title;
    private String releaseDate;
    private String author;
    private String category;
    private String editorial;
    private String language;
    private Integer pages;
    private String description;
    private String bookCover;


    public BookDto() {
    }

    public BookDto(Book book) {
        bookId = book.getBookId();
        title = book.getTitle();
        releaseDate = book.getReleaseDate();
        author = book.getAuthor();
        language = book.getLanguage();
        pages = book.getPages();
        description = book.getDescription();
        bookCover = book.getBookCover();
    }

    public BookDto(Integer bookId, String title, String releaseDate, String author, String category, String editorial, String language, Integer pages, String description, String bookCover) {
        this.bookId = bookId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.author = author;
        this.category = category;
        this.editorial = editorial;
        this.language = language;
        this.pages = pages;
        this.description = description;
        this.bookCover = bookCover;
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

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEditorial() {
        return this.editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
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



    @Override
    public String toString() {
        return "BookDto{" +
            " bookId='" + bookId + 
            ", title='" + title + '\'' +
            ", releaseDate='" + releaseDate + '\'' +
            ", author='" + author + '\'' +
            ", category='" + category + '\'' +
            ", editorial='" + editorial + '\'' +
            ", language='" + language + '\'' +
            ", pages='" + pages + '\'' +
            ", description='" + description + '\'' +
            ", bookCover='" + bookCover + '\'' +
            '}';
    }

}

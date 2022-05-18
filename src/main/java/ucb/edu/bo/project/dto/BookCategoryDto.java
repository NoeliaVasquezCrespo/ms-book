package ucb.edu.bo.project.dto;

import ucb.edu.bo.project.entity.BookCategory;

public class BookCategoryDto {
    private Integer bookcategoryId;
    private Integer bookId;
    private Integer categoryId;


    public BookCategoryDto() {
    }

    public BookCategoryDto(BookCategory bookcategory) {
        bookcategoryId = bookcategory.getBookcategoryId();
        bookId = bookcategory.getBookId();
        categoryId = bookcategory.getCategoryId();
         
    }
 

    public BookCategoryDto(Integer bookcategoryId, Integer bookId, Integer categoryId) {
        this.bookcategoryId = bookcategoryId;
        this.bookId = bookId;
        this.categoryId = categoryId;
    }

    public Integer getBookcategoryId() {
        return this.bookcategoryId;
    }

    public void setBookcategoryId(Integer bookcategoryId) {
        this.bookcategoryId = bookcategoryId;
    }

    public Integer getBookId() {
        return this.bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public BookCategoryDto bookcategoryId(Integer bookcategoryId) {
        setBookcategoryId(bookcategoryId);
        return this;
    }

    public BookCategoryDto bookId(Integer bookId) {
        setBookId(bookId);
        return this;
    }

    public BookCategoryDto categoryId(Integer categoryId) {
        setCategoryId(categoryId);
        return this;
    }

    

    @Override
    public String toString() {
        return "BookCategoryDto{" +
            " bookcategoryId='" + bookcategoryId +
            ", bookId='" + bookId + '\'' +
            ", categoryId='" + categoryId + '\'' +
            '}';
    }
    

}

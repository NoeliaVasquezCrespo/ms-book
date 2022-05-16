package ucb.edu.bo.project.dto;

import ucb.edu.bo.project.entity.Category;

public class CategoryDto {
    private Integer categoryId;
    private String category;


    public CategoryDto() {
    }

    public CategoryDto(Category categories) {
        categoryId = categories.getCategoryId();
        category = categories.getCategory();
         
    }
    public CategoryDto(Integer categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CategoryDto categoryId(Integer categoryId) {
        setCategoryId(categoryId);
        return this;
    }

    public CategoryDto category(String category) {
        setCategory(category);
        return this;
    }


    @Override
    public String toString() {
        return "CategoryDto{" +
            " categoryId='" + categoryId +
            ", category='" + category + '\'' +
            '}';
    }

}

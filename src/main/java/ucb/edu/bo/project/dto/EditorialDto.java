package ucb.edu.bo.project.dto;

import ucb.edu.bo.project.entity.Editorial;

public class EditorialDto {
    private Integer editorialId;
    private String editorial;


    public EditorialDto() {
    }

    public EditorialDto(Editorial editorials) {
        editorialId = editorials.getEditorialId();
        editorial = editorials.getEditorial();
         
    }

    public EditorialDto(Integer editorialId, String editorial) {
        this.editorialId = editorialId;
        this.editorial = editorial;
    }

    public Integer getEditorialId() {
        return this.editorialId;
    }

    public void setEditorialId(Integer editorialId) {
        this.editorialId = editorialId;
    }

    public String getEditorial() {
        return this.editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public EditorialDto editorialId(Integer editorialId) {
        setEditorialId(editorialId);
        return this;
    }

    public EditorialDto editorial(String editorial) {
        setEditorial(editorial);
        return this;
    }


    @Override
    public String toString() {
        return "EditorialDto{" +
            " editorialId='" + editorialId +
            ", editorial='" + editorial + '\'' +
            '}';
    }

}

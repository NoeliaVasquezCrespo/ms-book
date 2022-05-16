package ucb.edu.bo.project.dto;

import ucb.edu.bo.project.entity.Author;

public class AuthorDto {
    private Integer authorId;
    private String name;



    public AuthorDto() {
    }

    public AuthorDto(Author author) {
       authorId = author.getAuthorId();
       name = author.getName();
        
    }

    public AuthorDto(Integer authorId, String name) {
        this.authorId = authorId;
        this.name = name;
    }

    public Integer getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorDto authorId(Integer authorId) {
        setAuthorId(authorId);
        return this;
    }

    public AuthorDto name(String name) {
        setName(name);
        return this;
    }


    @Override
    public String toString() {
        return "AuthorDto{" +
            " authorId='" + authorId +
            ", name='" + name + '\'' +
            '}';
    }

}

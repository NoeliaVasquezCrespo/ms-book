-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-05-17 15:24:29.336

-- tables
-- Table: Author
CREATE TABLE Author (
    author_id serial  NOT NULL,
    name varchar(250)  NOT NULL,
    CONSTRAINT Author_pk PRIMARY KEY (author_id)
);

-- Table: Book
CREATE TABLE Book (
    book_id serial  NOT NULL,
    title varchar(250)  NOT NULL,
    release_date date  NOT NULL,
    author_id int  NOT NULL,
    editorial_id int  NOT NULL,
    language varchar(250)  NOT NULL,
    pages serial  NOT NULL,
    description varchar(250)  NOT NULL,
    book_cover varchar(250)  NOT NULL,
    status int  NOT NULL,
    CONSTRAINT Book_pk PRIMARY KEY (book_id)
);

-- Table: Book_Category
CREATE TABLE Book_Category (
    book_category_id serial  NOT NULL,
    book_id int  NOT NULL,
    category_id int  NOT NULL,
    CONSTRAINT Book_Category_pk PRIMARY KEY (book_category_id)
);

-- Table: Category
CREATE TABLE Category (
    category_id serial  NOT NULL,
    category varchar(250)  NOT NULL,
    CONSTRAINT Category_pk PRIMARY KEY (category_id)
);

-- Table: Editorial
CREATE TABLE Editorial (
    editorial_id serial  NOT NULL,
    editorial varchar(250)  NOT NULL,
    CONSTRAINT Editorial_pk PRIMARY KEY (editorial_id)
);

-- foreign keys
-- Reference: Book_Author (table: Book)
ALTER TABLE Book ADD CONSTRAINT Book_Author
    FOREIGN KEY (author_id)
    REFERENCES Author (author_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Book_Category_Book (table: Book_Category)
ALTER TABLE Book_Category ADD CONSTRAINT Book_Category_Book
    FOREIGN KEY (book_id)
    REFERENCES Book (book_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Book_Category_Category (table: Book_Category)
ALTER TABLE Book_Category ADD CONSTRAINT Book_Category_Category
    FOREIGN KEY (category_id)
    REFERENCES Category (category_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Book_Editorial (table: Book)
ALTER TABLE Book ADD CONSTRAINT Book_Editorial
    FOREIGN KEY (editorial_id)
    REFERENCES Editorial (editorial_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.


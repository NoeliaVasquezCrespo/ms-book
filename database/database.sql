/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     5/15/2022 10:33:33 PM                        */
/*==============================================================*/


drop table book;

drop table author;

drop table category;

drop table editorial;


-- Table: Author
CREATE TABLE Author (
    id serial  NOT NULL,
    name varchar(250)  NOT NULL,
    CONSTRAINT Author_pk PRIMARY KEY (id)
);

-- Table: Book
CREATE TABLE Book (
    id serial  NOT NULL,
    title varchar(250)  NOT NULL,
    release_date varchar(250)  NOT NULL,
    author_id int  NOT NULL,
    category_id int  NOT NULL,
    editorial_id int  NOT NULL,
    editorial varchar(250)  NOT NULL,
    language varchar(250)  NOT NULL,
    pages serial  NOT NULL,
    description varchar(250)  NOT NULL,
    book_cover varchar(250)  NOT NULL,
    CONSTRAINT Book_pk PRIMARY KEY (id)
);

-- Table: Category
CREATE TABLE Category (
    id serial  NOT NULL,
    category varchar(250)  NOT NULL,
    CONSTRAINT Category_pk PRIMARY KEY (id)
);

-- Table: Editorial
CREATE TABLE Editorial (
    id serial  NOT NULL,
    editorial varchar(250)  NOT NULL,
    CONSTRAINT Editorial_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Book_Author (table: Book)
ALTER TABLE Book ADD CONSTRAINT Book_Author
    FOREIGN KEY (author_id)
    REFERENCES Author (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Book_Category (table: Book)
ALTER TABLE Book ADD CONSTRAINT Book_Category
    FOREIGN KEY (category_id)
    REFERENCES Category (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Book_Editorial (table: Book)
ALTER TABLE Book ADD CONSTRAINT Book_Editorial
    FOREIGN KEY (editorial_id)
    REFERENCES Editorial (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.


-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-05-24 05:35:11.108

-- tables
-- Table: Address
CREATE TABLE Address (
    address_id serial  NOT NULL,
    address varchar(100)  NOT NULL,
    postal_code int  NOT NULL,
    status int  NOT NULL,
    CONSTRAINT Address_pk PRIMARY KEY (address_id)
);

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
    id_book_category serial  NOT NULL,
    book_id int  NOT NULL,
    category_id int  NOT NULL,
    CONSTRAINT Book_Category_pk PRIMARY KEY (id_book_category)
);

-- Table: Category
CREATE TABLE Category (
    category_id serial  NOT NULL,
    category varchar(250)  NOT NULL,
    CONSTRAINT Category_pk PRIMARY KEY (category_id)
);

-- Table: Client
CREATE TABLE Client (
    client_id serial  NOT NULL,
    name varchar(250)  NOT NULL,
    lastname varchar(250)  NOT NULL,
    email varchar(250)  NOT NULL,
    phone int  NOT NULL,
    address_id int  NOT NULL,
    status int  NOT NULL,
    CONSTRAINT Client_pk PRIMARY KEY (client_id)
);

-- Table: Editorial
CREATE TABLE Editorial (
    editorial_id serial  NOT NULL,
    editorial varchar(250)  NOT NULL,
    CONSTRAINT Editorial_pk PRIMARY KEY (editorial_id)
);

-- Table: Loan
CREATE TABLE Loan (
    loan_id serial  NOT NULL,
    client_id int  NOT NULL,
    loan_date date  NOT NULL,
    return_date date  NOT NULL,
    status int  NOT NULL,
    CONSTRAINT Loan_pk PRIMARY KEY (loan_id)
);

-- Table: Loan_details
CREATE TABLE Loan_details (
    loan_details_id serial  NOT NULL,
    book_id int  NOT NULL,
    loan_id int  NOT NULL,
    loan_status varchar(20)  NOT NULL,
    status int  NOT NULL,
    CONSTRAINT Loan_details_pk PRIMARY KEY (loan_details_id)
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

-- Reference: Client_Address (table: Client)
ALTER TABLE Client ADD CONSTRAINT Client_Address
    FOREIGN KEY (address_id)
    REFERENCES Address (address_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Loan_Client (table: Loan)
ALTER TABLE Loan ADD CONSTRAINT Loan_Client
    FOREIGN KEY (client_id)
    REFERENCES Client (client_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Loan_details_Book (table: Loan_details)
ALTER TABLE Loan_details ADD CONSTRAINT Loan_details_Book
    FOREIGN KEY (book_id)
    REFERENCES Book (book_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Loan_details_Loan (table: Loan_details)
ALTER TABLE Loan_details ADD CONSTRAINT Loan_details_Loan
    FOREIGN KEY (loan_id)
    REFERENCES Loan (loan_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.


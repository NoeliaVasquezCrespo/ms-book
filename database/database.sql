/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     5/15/2022 10:33:33 PM                        */
/*==============================================================*/


drop table BOOK;

drop table AUTHOR;

drop table CATEGORY;

drop table EDITORIAL;

/*==============================================================*/
/* Table: BOOK                                               */
/*==============================================================*/
create table BOOK (
   ID                   SERIAL               not null,
   TITLE                VARCHAR(250)         null,
   RELEASE_DATE         VARCHAR(250)         null,
   AUTHOR               VARCHAR(250)         null,
   CATEGORY             VARCHAR(250)         null,
   EDITORIAL            VARCHAR(250)         null,
   LANGUAGE             VARCHAR(250)         null,   
   PAGES                VARCHAR(250)         null,
   DESCRIPTION          VARCHAR(250)         null,
   BOOK_COVER           VARCHAR(250)         null
   constraint PK_BOOK primary key (ID)
);

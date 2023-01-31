BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, user_books, book;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)

);

 CREATE TABLE book (
    author varchar (100),
    title varchar (100),
    isbn varchar (100),
    book_id INTEGER NOT NULL ,
	CONSTRAINT PK_book_id PRIMARY KEY (book_id)
);


CREATE TABLE user_books (
    user_books_ID SERIAL,
    user_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    CONSTRAINT FK_book_id FOREIGN KEY (book_id) REFERENCES book (book_id) ,
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id) ,
    CONSTRAINT PK_user_books PRIMARY KEY (user_books_ID)

 );



COMMIT TRANSACTION;

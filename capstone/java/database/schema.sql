BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, book, prizes, family, members, family_activity;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)

);

CREATE TABLE family (
       family_id SERIAL,
       family_name varchar (100),
       CONSTRAINT PK_family_id PRIMARY KEY (family_id)

);
CREATE TABLE members (
        member_id SERIAL,
        first_name varchar (50),
        last_name varchar (50),
        member_role varchar (20),
        family_id int,
        user_id int,
        CONSTRAINT PK_member_id PRIMARY KEY (member_id),
        CONSTRAINT FK_family_id FOREIGN KEY (family_id) REFERENCES family (family_id),
        CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

 CREATE TABLE book (
    author varchar (100),
    title varchar (100),
    isbn varchar (100),
    book_id SERIAL,
    member_id int,
	CONSTRAINT PK_book_id PRIMARY KEY (book_id),
	CONSTRAINT FK_member_id FOREIGN KEY (member_id) REFERENCES members (member_id)
);



CREATE TABLE family_activity (
            activity_id SERIAL,
            reading_time int,
            book_format varchar (50),
            reading_notes varchar (1000),
            member_id int,
            family_id int,
            book_id int,
         CONSTRAINT PK_activity_id PRIMARY KEY (activity_id),
         CONSTRAINT FK_member_id FOREIGN KEY (member_id) REFERENCES members (member_id),
         CONSTRAINT FK_book_id FOREIGN KEY (book_id) REFERENCES book (book_id),
         CONSTRAINT FK_family_id FOREIGN KEY (family_id) REFERENCES family (family_id)

);
CREATE TABLE prizes (
            prize_id SERIAL,
            prize_name varchar (100),
            prize_description varchar (100),
            milestone int,
            user_group varchar (30),
            max_prizes int,
            start_date TIMESTAMP,
            end_date TIMESTAMP,
            family_id int,
            member_id int,

            CONSTRAINT PK_prize_id PRIMARY KEY (prize_id),
            CONSTRAINT FK_member_id FOREIGN KEY (member_id) REFERENCES members (member_id),
            CONSTRAINT FK_family_id FOREIGN KEY (family_id) REFERENCES family (family_id)
);

COMMIT TRANSACTION;

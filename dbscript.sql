	DROP TABLE it353finalproject;

	CREATE TABLE it353finalproject.users
	(
		email		VARCHAR(50) not null primary key (START WITH 1, INCREMENT BY 1),
		password	VARCHAR(30) not null,
		fullname	VARCHAR(100) not null,
		subscribed	BOOLEAN default false,
		userlevel	VARCHAR(30) not null,
		phonenumber	VARCHAR(20) not null
	);

	CREATE TABLE it353finalproject.media
	(
		uid int not null primary key AUTO_INCREMENT,
		url VARCHAR(500) not null,
		price double(10,2) not null default (0.00),
		author VARCHAR(100),
		FOREIGN KEY (author) REFERENCES users(email)
	);

	CREATE TABLE it353finalproject.weeklywinners
	(
		win_date date primary key,
		winner_media_id int,
		FOREIGN KEY (winner_media_id) REFERENCES media(uid)	
	);

	CREATE TABLE it353finalproject.cart
	(
		cart_uid	int primary key AUTO_INCREMENT,
		email		VARCHAR(50),
		media_id	int,
		FOREIGN KEY (email) REFERENCES users(email),
		FOREIGN KEY (media_id) REFERENCES media(uid)	
	);

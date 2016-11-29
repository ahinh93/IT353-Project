drop table weeklywinners;
drop table cart;
drop table media;
drop table users;

CREATE TABLE users
(
email		VARCHAR(50) not null constraint email_pk primary key,
password	VARCHAR(30) not null,
fullname	VARCHAR(100) not null,
subscribed	BOOLEAN default false,
userlevel	VARCHAR(30) default 'standard',
phonenumber	VARCHAR(20) not null
);

CREATE TABLE media
(
uid int not null generated always as identity constraint media_pk primary key,
url blob not null,
price double not null,
author VARCHAR(50) references users(email)
);

CREATE TABLE weeklywinners
(
win_date date constraint win_key primary key,
winner_media_id int references media(uid),
beenpaid boolean default false
);

CREATE TABLE cart
(
cart_uid int not null generated always as identity constraint cart_key primary key,
email VARCHAR(50) references users(email),
media_id int references media(uid)
);
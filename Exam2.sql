CREATE DATABASE EXAM2

USE EXAM2;

create table addressbook (
ID int primary key identity(1,1),
name varchar(50) not null,
company varchar(50) not null,
email varchar(50) not null,
phone varchar(20) not null unique,
);


insert into addressbook(name, company, email, phone)
  values('TrungDH','FU','trung@gmail.com','0904818238'),
  ('HoangVH','FPT','hoang@gmail.com','0383753688')

  select * from addressbook
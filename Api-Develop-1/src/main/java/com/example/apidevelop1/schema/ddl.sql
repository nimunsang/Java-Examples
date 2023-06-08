create database mytest;

create table User
(
    id        int auto_increment primary key ,
    email     varchar(50) not null,
    name  varchar(50) not null,
    createdDate date    not null
);

create table Post
(
    id  int auto_increment primary key,
    title varchar(50) not null,
    content varchar(1000) not null,
    category varchar(50) not null,
    memberId int not null,
    createdAt datetime not null
);
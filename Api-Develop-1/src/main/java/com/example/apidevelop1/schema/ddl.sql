create database mytest;

create table User
(
    id        int auto_increment primary key ,
    email     varchar(50) not null,
    name  varchar(50) not null,
    createdDate date    not null
);


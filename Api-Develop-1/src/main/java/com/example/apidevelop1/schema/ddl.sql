create database mytest;

create table User
(
    id        long auto_increment primary key ,
    email     varchar(50) not null,
    name  varchar(50) not null,
    createdDate date    not null
);

create table Post
(
    id  long auto_increment primary key,
    title varchar(50) not null,
    content varchar(1000) not null,
    category varchar(50) not null,
    userId long not null,
    createdAt datetime not null
);

create table Follow
(
    id  int auto_increment primary key,
    fromId int not null,
    toId int not null,
    createdAt DATETIME not null
)
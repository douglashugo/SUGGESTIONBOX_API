create table categories (
    id int primary key auto_increment,
    description varchar(70) not null
);

insert into categories (description) values
('test1'),
('test2'),
('test3');
create database 과제11;
use 과제11;
create table product(
	pno int auto_increment primary key , -- 제품번호 
    pname varchar(20) , 
    pprice int ,
    pstock int 
);
create database airline;
use airline;

create table login(username varchar(20), password varchar(20));
insert into login values("admin","admin");

create table passengers(username varchar(20), nationality varchar(20), aadhar varchar(20), address varchar(50), phone varchar(10), gender varchar(20));
select * from passengers;

create table flights(f_code varchar(20), f_name varchar(20), f_source varchar(20), f_destination varchar(20));
insert into flights values("1001","A-1","Delhi","Mumbai"),
("1002","A-2","Delhi","Mumbai"),
("1003","A-3","Mumbai","Jaipur"),
("1004","A-4","Jaipur","Jodhpur"),
("1005","A-5","Bhopal","Delhi"),
("1006","A-6","Ahemdabad","Ajmer"),
("1007","A-7","Delhi","Chennai"),
("1008","A-8","Jodhpur","Goa");

select * from flights;

select username from passengers where aadhar = '12345678';

create table reservations(ticket varchar(20), aadhar varchar(20), name varchar(20), address varchar(50), nationality varchar(10), gender varchar(10), source varchar(20), destination varchar(20), date varchar(20), f_name varchar(10), f_code varchar(15));
DROP TABLE reservations;
select * from reservations;
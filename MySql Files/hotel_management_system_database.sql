CREATE DATABASE hotelmanagementsystem;   

USE hotelmanagementsystem;

CREATE TABLE login(username varchar(25), password varchar(25));

INSERT INTO login VALUES('admin', '12345');
INSERT INTO login VALUES('dayalu_patel', '123456');

-- select*from login; 

CREATE TABLE employee(name varchar(25), age varchar(25), gender varchar(25), job varchar(25), salary varchar(25), phone varchar(25), email varchar(25), aadhar varchar(25));

-- describe employee;

-- select* from  employee;

CREATE TABLE room(roomnumber varchar(20), availability varchar(20), cleaning_status varchar(20), price varchar(20), bed_type varchar(20) ); 

-- describe room;
-- select*from room ;

CREATE TABLE driver(name varchar(20), age varchar(20), gender varchar(20), company varchar(25), model varchar(25), available varchar(25), location varchar(25) ); 

-- select*from driver;

CREATE TABLE customerInfo(document varchar(20), number varchar(20), name varchar(30), gender varchar(30), country varchar(30), room varchar(10), checkintime varchar(80), deposit varchar(20) );

-- describe customerInfo;
-- select * from customerInfo; 
CREATE TABLE department(department varchar(30), budget varchar(30));

CREATE TABLE records(document varchar(20), number varchar(20), name varchar(30), gender varchar(30), country varchar(30), room varchar(10), checkintime varchar(80), checkouttime varchar(80) );
-- select*from records;
-- insert into department values('Front office', '500000');
-- insert into department values('Housekeeping', '40000');
-- insert into department values('Food and Beverage', '23000');
-- insert into department values('Kitchen or Food Production', 540000);
-- insert into department values('Security', '320000');

-- select * from department;
-- drop database hotelmanagementsystem;

-- describe login;
-- update room set availability = 'available';
-- select * from room;


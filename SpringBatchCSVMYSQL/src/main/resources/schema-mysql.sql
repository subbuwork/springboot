DROP table IF EXISTS CUSTOMER;
CREATE table CUSTOMER(
cid INT PRIMARY KEY NOT NULL,
fName varchar(20),
lName varchar(20),
address varchar(50)
);
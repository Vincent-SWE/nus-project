-- ----- SQL statment if I need to reset the id back to start from 1 -----
-- alter table customer auto_increment = 5;


-- ----- Creating a Database and selecting it to be used -----
-- create database bloodbank;
-- use bloodbank;


-- ------------- Creating a table for blood stock --------------
-- create table stock (
-- id int not null auto_increment,
-- blood_type varchar(3) not null,
-- amount int,
-- constraint stock_pk primary key (id)
-- );


-- ----- CRUD for stock table -----
-- ----- Insert (CREATE) -----
-- insert into stock (blood_type, amount) values ('A', 80);
-- insert into stock (blood_type, amount) values ('B', 70);
-- insert into stock (blood_type, amount) values ('AB', 60);
-- insert into stock (blood_type, amount) values ('O', 50);

-- ----- Read (SELECT) -----
-- select * from stockoutlets
-- select * from stock where id = 1;
-- select * from stock where blood_type = 'B';

-- ----- Update -----
-- update stock set amount = 9000 where id = 3;

-- ------------- Creating a table for customer --------------
-- create table customer (
-- id int not null auto_increment,
-- first_name varchar(30) not null,
-- last_name varchar(30) not null,
-- constraint customer_pk primary key (id)
-- );

-- ----- CRUD for customer table -----
-- ----- Insert (CREATE) -----
-- insert into customer (first_name, last_name) values ('Alpha', 'Bravo');
-- insert into customer (first_name, last_name) values ('Charlie', 'Delta');
-- insert into customer (first_name, last_name) values ('Echo', 'Foxtrot');
-- insert into customer (first_name, last_name) values ('Golf', 'Hotel');

-- ----- Read (Select) -----
-- select * from customer;
-- select * from customer where id = 5; 
-- select * from customer where first_name = 'charlie';
-- select * from customer order by id desc limit 1;

-- Update (Update) -----
-- update customer set last_name = 'Foxtrot Foxtrot' where id = 3;

-- ----- Delete (Delete) -----
-- delete from customer where id = 7;
-- delete from customer where id between 14 and 18;



-- ------------- Creating a table for outlets --------------
-- create table outlets (
-- id int not null auto_increment,
-- building_name varchar(30) not null,
-- address varchar(30) not null,
-- constraint outlets_pk primary key (id)
-- );

-- ----- Creating a table for outlets -----
-- ----- CRUD for outlets table -----
-- ----- Insert (CREATE)
-- insert into outlets (building_name, address) values ('HSA Building', '11 Outram Road');
-- insert into outlets (building_name, address) values ('Dhoby Xchange', '11 Orchard Road');
-- insert into outlets (building_name, address) values ('Woodlands Civic Centre', '900 South Woodlands Drive');
-- insert into outlets (building_name, address) values ('Westgate Tower', '1 Gateway Drive');

-- select * from outlets
-- delete from outlets where id = 1;


-- ----- Creating table for appointments -----
-- create table appointments (
-- id int not null auto_increment,1`
-- customer_id int not null,
-- outlets_id int not null,
-- appointments_date date,
-- constraint appointments_pk primary key (id),
-- constraint appointments_customer_fk foreign key (customer_id) references customer(id),
-- constraint appointments_outlets_fk foreign key (outlets_id) references outlets(id)
-- );

-- ----- Testing CRUD for appointments table -----
-- ----- Insert (CREATE) 
-- insert into appointments (customer_id, outlets_id, appointments_date) values (1, 1, "2023-01-01");
-- insert into appointments (customer_id, outlets_id, appointments_date) values (2, 2, "2023-02-02");
-- insert into appointments (customer_id, outlets_id, appointments_date) values (3, 3, "2023-03-03");
-- insert into appointments (customer_id, outlets_id, appointments_date) values (4, 4, "2023-04-04");

-- ----- Select (READ) -----
-- select * from appointments;
-- select * from appointments where id = 2;


-- ----- Update (Update) -----
-- update appointments set appointments_date = "2023-06-12" where id = 1;

-- ----- Delete (Delete) -----
-- delete from appointments where id = 5;

-- ----- Basic inner join for customer table and appointments table -----
-- select cust.id as customer_id, cust.first_name, cust.last_name, appt.appointments_date
-- from customer as cust
-- inner join appointments as appt
-- on cust.id = appt.customer_id

-- ----- Complex inner join for customer table and appointments table -----
-- select cust.id as customer_id, outt.id as outlets_id, cust.first_name, cust.last_name, outt.building_name, outt.address, appt.appointments_date
-- from customer as cust
-- inner join appointments as appt on cust.id = appt.customer_id
-- inner join outlets as outt on outt.id = appt.outlets_id

-- ----- Complex inner join for customer table and appointments table by ID -----
-- select cust.id as customer_id, outt.id as outlets_id, cust.first_name, cust.last_name, outt.building_name, outt.address, appt.appointments_date
-- from customer as cust
-- inner join appointments as appt on cust.id = appt.customer_id
-- inner join outlets as outt on outt.id = appt.outlets_id
-- where appt.id = 9;

-- ----- Complex inner join for customer table and appointments table by customer ID -----
-- select cust.id as customer_id, outt.id as outlets_id, cust.first_name, cust.last_name, outt.building_name, outt.address, appt.appointments_date
-- from customer as cust
-- inner join appointments as appt on cust.id = appt.customer_id
-- inner join outlets as outt on outt.id = appt.outlets_id
-- where cust.id = 9;



drop database if exists realestatedb;
create database realestatedb;
use realestatedb;

create table address (
	address_id int auto_increment,
    sub_city varchar (30),
    district varchar (30),
    house_number varchar (30),
    constraint address_pk primary key (address_id)
);
create table realtor (
	realtor_id int auto_increment,
     address_id int ,
    first_name varchar (30),
    last_name varchar (30),
    email_id varchar (30),
    password varchar (30),
    phone_number varchar (30),
    constraint realtor_pk primary key(realtor_id),
    constraint realtor_address_fk 
		Foreign key (address_id) references address (address_id)
   );
   insert into address values (1, 'Bole', '01', '123');
   insert into realtor values (1, 1, 'Hab', 'Teg', 'habteg@email.com', '12345', '1234567891');

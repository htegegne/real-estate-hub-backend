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
   CREATE TABLE property_address (

		property_address_id int PRIMARY KEY auto_increment,
		sub_city varchar (30),
		district varchar (30),
		house_number varchar (30),
        block_name varchar (30)
);
	CREATE TABLE property (
		property_id int PRIMARY KEY auto_increment,
		title varchar (255),
        description TEXT,
        price DECIMAL(10,2),
        area DECIMAL(10,2),
        bedrooms int,
        bathrooms DECIMAL(10,2),
        property_address_id INT NOT NULL,
        realtor_id INT NOT NULL,
        FOREIGN KEY (property_address_id) REFERENCES property_address(property_address_id),
		FOREIGN KEY (realtor_id) REFERENCES realtor(realtor_id)
        
        
    );
     insert into address (sub_city, district, house_number)
		values ('Financial District', 'Wall Street', '100 Broad St'),  
       ('Midtown Manhattan', 'Times Square', '123 Broadway'),  
       ('Silicon Valley', 'Mountain View', '456 El Camino Real'),  
       ('Hollywood Hills', 'Sunset Strip', '789 Sunset Blvd'),  
       ('French Quarter', 'Bourbon Street', '1011 Bourbon St');
	INSERT INTO realtor (first_name, last_name, email_id, phone_number, password, address_id)
VALUES ('John', 'Doe', 'john.doe@example.com', '555-123-4567', 'password123', 1),
       ('Jane', 'Smith', 'jane.smith@example.com', '555-789-0123', 'password456', 2),
       ('Michael', 'Jones', 'michael.jones@example.com', '555-345-6789', 'password789', 3),
       ('Sarah', 'Lee', 'sarah.lee@example.com', '555-901-2345', 'password012', 4),
       ('David', 'Miller', 'david.miller@example.com', '555-567-8901', 'password345', 1);
    INSERT INTO property_address (sub_city, district, house_number, block_name)
VALUES ('Central Business District', 'Downtown Area', '123 Main St', NULL),
       ('Suburban Neighborhood', 'Pleasantville', '456 Elm St', NULL),
       ('Beachfront District', 'Ocean View', '789 Beach Blvd', NULL),
       ('University District', 'College Town', '1011 Campus Ave', NULL),
       ('Historic District', 'Old Town', '1213 Heritage St', NULL);
    INSERT INTO property (title, description, price, area, bedrooms, bathrooms, property_address_id, realtor_id)
VALUES ('Spacious Apartment Downtown', 'Modern apartment with amazing city views', 1500.00, 800.00, 2, 1.5, 1, 1),
       ('Cozy Bungalow in Suburbs', 'Charming single-family home with a backyard', 800.00, 1200.00, 3, 2.0, 2, 2),
       ('Luxury Beachfront Condo', 'Stunning oceanfront property with private balcony', 3000.00, 1500.00, 4, 3.0, 3, 3),
       ('Studio Apartment near Campus', 'Perfect for students, close to university', 700.00, 400.00, 1, 1.0, 4, 1),
       ('Historic Townhouse', 'Unique property with character and charm', 1200.00, 1000.00, 2, 2.5, 1, 2);
  
  -- insert into realtor values (1, 1, 'Hab', 'Teg', 'habteg@email.com', '12345', '1234567891');

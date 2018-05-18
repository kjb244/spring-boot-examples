drop table if exists shipwreck;
drop table if exists address_info;
drop table if exists customer;


create table shipwreck(
	id int auto_increment,
	name varchar(255),
	description varchar(2000),
	condition varchar(255),
	depth int,
	latitude double,
	longitude double,
	year_discovered int
);



create table customer(
	id int primary key auto_increment,
	first_name varchar(100),
	last_name varchar(100)
);




create table address_info(
	id int primary key auto_increment,
	customer_info_id int,
	address_type varchar(10),
	address_line_1 varchar(100),
	address_line_2 varchar(100),
	city varchar(100),
	state varchar(2),
	zip varchar(20),
	foreign key (customer_info_id) references customer(id)
);

insert into customer(first_name, last_name) values ('kevin','bacino');
insert into customer(first_name, last_name) values ('sally', 'johnson');
insert into address_info(customer_info_id, address_type, address_line_1, address_line_2, city, state, zip) values (1, 'Mailing', '932', 'test lane', 'Charlotte', 'NC', '28204');
insert into address_info(customer_info_id, address_type, address_line_1, address_line_2, city, state, zip) values (1, 'Remittance', '934', 'test lane', 'Charlotte', 'NC', '28204');
commit;


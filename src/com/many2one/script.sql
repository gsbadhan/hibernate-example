'many to one mapping'

'one address map to multiple employees'

create table address(addres_id integer auto_increment,
city varchar(20),
primary key(addres_id)
);


create table emp(emp_id integer auto_increment, 
name varchar(20),
emp_addres_id integer,
primary key(emp_id),
foreign key (emp_addres_id) references address(addres_id) on delete set null
);


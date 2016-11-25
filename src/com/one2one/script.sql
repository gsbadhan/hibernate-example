
'1-1 mapping'
'one student has one student_info entry'

create table student
(stud_id integer not null, stud_name varchar(30) not null,
primary key(stud_id)
);


create table student_info
(stud_id integer not null,
class varchar(5),
section varchar(1),
primary key(stud_id),
foreign key (stud_id) references student(stud_id)
);


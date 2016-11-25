'many to many mapping'


create table students
(
stud_id integer primary key auto_increment,
name varchar(20)
);

create table courses
(
course_id integer primary key auto_increment,
name varchar(20)
);

create table student_cources
(
sc_stud_id integer,
sc_cource_id integer,
primary key(sc_stud_id,sc_cource_id),
foreign key (sc_stud_id) references students(stud_id),
foreign key (sc_cource_id) references courses(course_id)
);


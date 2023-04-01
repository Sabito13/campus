insert into user_data values('admin','ROLE_ADMIN','freeze','mail@com','juan','$2a$10$ZUQjsajCqyKcFsrDtSobTe6OzLCQP3JXKqQXNTEwY3qWLH8Flb6Wa'),
('student1','ROLE_STUDENT','freeze6','1mail@com','juan','$2a$10$ZUQjsajCqyKcFsrDtSobTe6OzLCQP3JXKqQXNTEwY3qWLH8Flb6Wa'),
('student2','ROLE_STUDENT','freeze7','2mail@com','juan','$2a$10$ZUQjsajCqyKcFsrDtSobTe6OzLCQP3JXKqQXNTEwY3qWLH8Flb6Wa'),
('student3','ROLE_STUDENT','freeze8','3mail@com','juan','$2a$10$ZUQjsajCqyKcFsrDtSobTe6OzLCQP3JXKqQXNTEwY3qWLH8Flb6Wa'),
('professor1','ROLE_PROFESSOR','freeze9','4mail@com','juan','$2a$10$ZUQjsajCqyKcFsrDtSobTe6OzLCQP3JXKqQXNTEwY3qWLH8Flb6Wa'),
('professor2','ROLE_PROFESSOR','freeze9','5mail@com','juan','$2a$10$ZUQjsajCqyKcFsrDtSobTe6OzLCQP3JXKqQXNTEwY3qWLH8Flb6Wa'),
('professor3','ROLE_PROFESSOR','freeze9','6mail@com','juan','$2a$10$ZUQjsajCqyKcFsrDtSobTe6OzLCQP3JXKqQXNTEwY3qWLH8Flb6Wa');

insert into student values(1,'student1'),
(2,'student2'),
(3,'student3');

insert into professor values(1,'Math','professor1'),
(2,'IT','professor2'),
(3,'IR','professor3');

insert into course values(1,'Math logic')
,(2,'Operating Systems')
,(3,'Comunication');


-- professor_in_course(id | course_id | professor_id)
--
insert into professor_in_course values(1,1,1),
(2,2,2),(3,3,3),(4,2,3);


--student_in_course(id | course_id | student_id)
--
insert into student_in_course values(1,1,1),(2,1,2),(3,1,3),
(4,2,1),(5,2,2),(6,2,1),
(7,3,1),(8,3,2);




--course_content(id | content | util_date | course_id)
--
insert into course_content values(1,'Welcome to Math 1','2023-04-01 16:34:27.353',1),
(2,'Welcome to SO','2023-04-01 16:34:27.353',2),
(3,'Welcome to Comunication 1','2023-04-01 16:34:27.353',3),
(4,'(a+b)=c','2023-04-01 16:34:27.353',1),
(5,'please solve the homework','2023-04-01 16:34:27.353',1),
(6,'please read chapters 1 to 234 for the next class','2023-04-01 16:34:27.353',2),
(7,'if you have any question please send to me','2023-04-01 16:34:27.353',2);
create table emp1
(
EMP_ID number(2),
EMP_NAME varchar2(10)
);


insert into emp1 values (1,'Tyson');
insert into emp1 values (2,'Justin');
insert into emp1 values (3,'Martin');
insert into emp1 values (4,'Jake');


create table emp_temp
(
EMP_ID number(2),
EMP_USERNAME varchar2(10),
EMP_PASS varchar2(10),
EMP_ROLES varchar2(50),
EMP_PERMISSIONS varchar2(50)
);


insert into emp_temp values (1,'Tyson','123','ADMIN','');
insert into emp_temp values (2,'Justin','123','USER','');
insert into emp_temp values (3,'Martin','123','ADMIN','MANAGER');
insert into emp_temp values (4,'Jake'',123','USER','MANAGER');
insert into emp_temp values (5,'Duke','123','ADMIN','LEAD');
insert into emp_temp values (6,'Fade'',123','USER','LEAD');

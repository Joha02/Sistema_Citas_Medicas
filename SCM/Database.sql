
create database nombre_de_la_Base; 

use scm; 

------------------------------MEDICOS-------------------------------------------------
create table medicos(id varchar(10) not null, password varchar(10) not null, name varchar(50) not null, especialidad varchar(18), costo int, ciudad varchar(50), direccion varchar(50), tipo varchar(10) not null, info varchar(200), estado int not null);

alter table medicos add constraint medicos_pk primary key (id);


------------------------------PACIENTES-------------------------------------------------
create table pacientes(id varchar(10) not null, password varchar(15) not null, name varchar(50) not null, tipo varchar(10) not null);

alter table pacientes add constraint pacientes_pk primary key (id);


------------------------------ADMINS-------------------------------------------------
create table admins(id varchar(10) not null, password varchar(15) not null, name varchar(50) not null, tipo varchar(10) not null);

alter table admins add constraint admins_pk primary key (id);

----------------------------CITAS-------------------------------------------------------
create table citas(id varchar(10) not null,  date varchar(50) not null,estado varchar(10) not null, anotaciones varchar(100) not null,  id_medico varchar(10) not null, id_paciente varchar(10));

alter table citas add constraint citas_pk primary key (id);

insert into medicos (id,password,name,especialidad, costo,ciudad, direccion, tipo,info,estado) values ('1', '111', 'Llerym', 'Cirugia', 60000, 'Alajuela', 'Desamparados', '1', 'info', 1);


insert into citas (id,date,estado,anotaciones, id_medico,id_paciente) values ('1', '25/03/2022 2.pm', 'Disponible', ' ', '1', null);

--------------------------------------------CIUDAD-------------------------------------------
create table ciudades(id varchar(10) not null, name varchar(50) not null, provincia varchar(50) not null);

alter table ciudades add constraint ciudades_pk primary key (id);

insert into ciudades(id, name) values ("234", "San Rafael", "Heredia");

-------------------------------------------ESPECIALIDADES----------------------------------------
create table especialidades(name varchar(50) not null);

alter table especialidades add constraint especia_pk primary key (name);

insert into especialidades(name) values ("Cirugia");
insert into especialidades(name) values ("Radiologia");
insert into especialidades(name) values ("Cardiologia");

/***************Table Admin****************/
SET FEEDBACK 1
SET NUMWIDTH 10
SET LINESIZE 3000
SET TRIMSPOOL ON
SET TAB OFF
SET PAGESIZE 100
SET ECHO OFF



CREATE TABLE ADMIN (
    id_admin int not null,
    name_admin varchar(50) not null UNIQUE,
    pwd_admin varchar(20) not null
);

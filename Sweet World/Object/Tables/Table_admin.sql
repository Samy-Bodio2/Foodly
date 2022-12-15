/***************Table Admin****************/
SET FEEDBACK 1
SET NUMWIDTH 10
SET LINESIZE 3000
SET TRIMSPOOL ON
SET TAB OFF
SET PAGESIZE 100
SET ECHO OFF



CREATE TABLE [ADMIN] (
    id_admin int not null,
    name_admin nvarchar(50) not null,
    pwd_admin nvarchar(20) not null
);

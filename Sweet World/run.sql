
Prompt
Prompt***************************** INSTALLING SWEET_WORLD SCHEMA *****************************
Prompt

SET FEEDBACK 1
SET NUMWIDTH 10
SET LINESIZE 3000
SET TRIMSPOOL ON
SET TAB OFF
SET PAGESIZE 100
SET ECHO OFF

ALTER SESSION SET NLS_LANGUAGE=English;
ALTER SESSION SET NLS_TERRITORY=America;
ALTER SESSION SET NLS_DATE_FORMAT='DD/MM/YYYY';

Prompt
Prompt***************************** CREATION USER  *****************************
Prompt

@users

Prompt
Prompt***************************** CREATION SEQUENCE  *****************************
Prompt

@Object/Sequence/main_sequence

Prompt
Prompt***************************** CREATION TABLE  *****************************
Prompt

@Object/Tables/main_table


Prompt
Prompt***************************** CREATION INDEX  *****************************
Prompt

@Object/Index/main_index

Prompt
Prompt***************************** CREATION PRIMARY KEY  *****************************
Prompt

@Object/Constraints/Primary_Key/main_Primary_Key

Prompt
Prompt***************************** CREATION FOREIGN KEY  *****************************
Prompt

@Object/Constraints/Foreign_Key/main_Foreign_Key

Prompt
Prompt***************************** CREATION CHECK  *****************************
Prompt

@Object/Check/main_check

Prompt
Prompt***************************** POPULATE TABLE  *****************************
Prompt

@Datas/main_datas

--Prompt
--Prompt***************************** CREATE PROCEDURE  *****************************
--Prompt

--@Procedure/main_procedure

Prompt
Prompt *******************************************************************JASON KAMSU*************************************************************************
Prompt

select table_name from user_tables;

--SELECT * FROM USERS;
--SELECT * FROM RESTAURANT;
--SELECT * FROM CUSTOMERS;
--SELECT * FROM DISH;
--SELECT * FROM COMPLEMENT;
--SELECT * FROM SECULANT;
--SELECT * FROM MENU;
--SELECT * FROM ORDERS;
--SELECT * FROM PANIER;
--SELECT * FROM NOTE;
--SELECT * FROM CONFIG;
--SELECT * FROM CONTROL_PANIER_MENU;
--
-- BY JASON KAMSU
--
Prompt
Prompt *******************************************************************SWEET_WORLD*************************************************************************
Prompt


Prompt
Prompt***************************** INSTALLING SWEET_WORLD SCHEMA *****************************
Prompt

SET LINESIZE 3000
SET PAGESIZE 1000
SET VERIFY OFF
SPOOL ON 

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

@Object/Constraints/Constraints_Sequence/main_sequence

Prompt
Prompt***************************** CREATION TABLE  *****************************
Prompt

@Object/Tables/main_table


Prompt
Prompt***************************** CREATION INDEX  *****************************
Prompt

@Object/Constraints/Constraints_Index/main_index

Prompt
Prompt***************************** CREATION UNIQUE  *****************************
Prompt

@Object/Constraints/Constraints_Unique/main_unique

Prompt
Prompt***************************** CREATION PRIMARY KEY  *****************************
Prompt

@Object/Constraints/Constraints_PK/main_Primary_Key

Prompt
Prompt***************************** CREATION FOREIGN KEY  *****************************
Prompt

@Object/Constraints/Constraints_FK/main_Foreign_Key

Prompt
Prompt***************************** CREATION CHECK  *****************************
Prompt

@Object/Constraints/Constraints_Check/main_check

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
 
SPOOL OFF
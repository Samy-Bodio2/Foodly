@configs

DROP USER swl CASCADE;

CREATE USER swl IDENTIFIED BY &pass;

PROMPT ALTER USER SET DEFAUT TABLE
ALTER USER swl DEFAULT TABLESPACE &tbs
              QUOTA UNLIMITED ON &tbs;
 
PROMPT ALTER USER GIVE A TEMPORARY TABLESSPACE
ALTER USER swl TEMPORARY TABLESPACE &ttbs;

PROMPT GRAND ACESS CREATE VIEW, ALTER SESSION, CREATE SEQUENCE TO swl
GRANT CREATE SESSION, CREATE VIEW, ALTER SESSION, CREATE SEQUENCE TO swl;

PROMPT GRANT CREATE SESSION, CREATE VIEW, ALTER SESSION, CREATE SEQUENCE TO swl
GRANT CREATE SYNONYM, CREATE DATABASE LINK, RESOURCE , UNLIMITED TABLESPACE TO swl;



CONNECT sys/&pass_sys@&connect_string AS SYSDBA;
GRANT execute ON sys.dbms_stats TO swl;

REM =================================================================================
REM create swl schema objects
REM ==================================================================================
CONNECT swl/&pass@&connect_string

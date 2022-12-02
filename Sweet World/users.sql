@configs

DROP USER sw CASCADE;

CREATE USER sw IDENTIFIED BY &pass;

PROMPT ALTER USER SET DEFAUT TABLE
ALTER USER sw DEFAULT TABLESPACE &tbs
              QUOTA UNLIMITED ON &tbs;
 
PROMPT ALTER USER GIVE A TEMPORARY TABLESSPACE
ALTER USER sw TEMPORARY TABLESPACE &ttbs;

PROMPT GRAND ACESS CREATE VIEW, ALTER SESSION, CREATE SEQUENCE TO sw
GRANT CREATE SESSION, CREATE VIEW, ALTER SESSION, CREATE SEQUENCE TO sw;

PROMPT GRANT CREATE SESSION, CREATE VIEW, ALTER SESSION, CREATE SEQUENCE TO sw
GRANT CREATE SYNONYM, CREATE DATABASE LINK, RESOURCE , UNLIMITED TABLESPACE TO sw;



CONNECT sys/&pass_sys@&connect_string AS SYSDBA;
GRANT execute ON sys.dbms_stats TO sw;

REM =================================================================================
REM create sw schema objects
REM ==================================================================================
CONNECT sw/&pass@&connect_string

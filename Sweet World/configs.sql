SET ECHO OFF
SET VERIFY OFF
SET LINESIZE 3000
SET PAGESIZE 1000

ALTER SESSION set container=xepdb1;

PROMPT 
PROMPT specify password for sw as parameter 1:
DEFINE pass     = sw
PROMPT 
PROMPT specify default tablespeace for ob as parameter 2:
DEFINE tbs      = users
PROMPT 
PROMPT specify temporary tablespace for ob as parameter 3:
DEFINE ttbs     = temp
PROMPT 
PROMPT specify password for SYS as parameter 4:
DEFINE pass_sys = jason
PROMPT 
PROMPT specify log path as parameter 5:
DEFINE log_path = logs/
PROMPT
PROMPT specify connect string as parameter 6:
DEFINE connect_string     = //localhost:1521/xepdb1
PROMPT
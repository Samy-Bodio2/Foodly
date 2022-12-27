ALTER SESSION SET NLS_LANGUAGE=English;
ALTER SESSION SET NLS_TERRITORY=America;
ALTER session set NLS_DATE_FORMAT='DD/MM/YYYY'

Prompt
Prompt***************************** CREATION PROCEDURE FOR SWEET_WORLD SCHEMA *****************************
Prompt


Prompt
Prompt***************************** PROCEDURE USER *****************************
Prompt

@Procedure/procedure_user

Prompt
Prompt***************************** PROCEDURE CUSTOMERS *****************************
Prompt

@Procedure/procedure_register_customers

Prompt
Prompt***************************** PROCEDURE RESTAUARNT *****************************
Prompt

@Procedure/procedure_register_restaurant

Prompt
Prompt *******************************************************************SWEET_WORLD*************************************************************************
Prompt


SET SERVEROUTPUT ON;
DECLARE 
v_choix CHAR(1) := '&choix';
BEGIN
DBMS_OUTPUT.PUT_LINE ('Bienvenue sur "Nom application" ');
DBMS_OUTPUT.PUT_LINE ('***********Menu*************** ');
DBMS_OUTPUT.PUT_LINE ('1. Inscription');
DBMS_OUTPUT.PUT_LINE ('2. Se connecter');
DBMS_OUTPUT.PUT_LINE ('3. Quitter');
DBMS_OUTPUT.PUT_LINE ('Que voulez-vous faire ? : ');
    CASE v_choix 
    WHEN '1' THEN 
    CREATE OR REPLACE PROCEDURE sp_register(p_id_cust IN INT,
                                        p_first_name IN VARCHAR,
                                        p_last_name IN VARCHAR,
                                        p_phone_number IN NUMBER,
                                        p_Email  IN VARCHAR,
                                        p_Datecd_cust  IN DATE,
                                        p_Cust_address   IN VARCHAR,
                                        p_id_users IN INT)
    IS
       l_msg  VARCHAR2(100);
   BEGIN
      INSERT INTO customers (id_cust,
                           first_name,
                          last_name,
                          phone_number,
                          Email,
                          Datecd_cust,
                          Cust_address,
                          id_user)
      SELECT p_id_cust,
             p_first_name,
             p_last_name,
             p_phone_number,
             p_Email,
             p_Datecd_cust,
             p_Cust_address,
             p_id_users
      FROM DUAL
      WHERE NOT EXISTS
              (SELECT NULL
               FROM customers
               WHERE id_cust = p_id_cust);
	   l_msg :=
             CASE
                 WHEN SQL%ROWCOUNT > 0 THEN 'Customer registered'
                 ELSE 'Customer already exists' 
              END;
   DBMS_OUTPUT.put_line(l_msg);
  END;
 /
    WHEN '2' THEN CREATE OR REPLACE PROCEDURE sp_users(p_id_user IN INT,
                                    p_username IN VARCHAR,
                                    p_password IN VARCHAR
                                    )
    IS
       l_msg  VARCHAR(100);
   BEGIN
      INSERT INTO Users (id_user,
                         username,
                         password
                        )
      SELECT p_id_user,
             p_username,
             p_password
      FROM DUAL
      WHERE NOT EXISTS
              (SELECT NULL
               FROM Users
               WHERE id_user = p_id_user);
	   l_msg :=
              CASE
                 WHEN SQL%ROWCOUNT > 0 THEN 'User registered'
                 ELSE 'User already exists' 
             END;
   DBMS_OUTPUT.put_line(l_msg);
   END;
   /
    WHEN '3' THEN 'Quitter'
    ELSE 'No such grade'
    END;
END;
/
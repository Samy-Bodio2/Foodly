SET SERVEROUTPUT ON;
DECLARE
BEGIN
IF c_cursor%found THEN
DBMS_OUTPUT.PUT_LINE ('Bienvenue sur "Nom application');
DBMS_OUTPUT.PUT_LINE ('***********Menu*************** ');
DBMS_OUTPUT.PUT_LINE ('1. Inscription');
DBMS_OUTPUT.PUT_LINE ('2. Se connecter');
DBMS_OUTPUT.PUT_LINE ('3. Quitter');
DBMS_OUTPUT.PUT_LINE ('Que voulez-vous faire?');
ELSE
DBMS_OUTPUT.PUT_LINE ('Entrer vos informations');
END IF;
END;
/
-------******BY TATSINKOU******-------
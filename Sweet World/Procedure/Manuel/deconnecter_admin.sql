SET SERVEROUTPUT ON;
DECLARE
test ADMIN.name_admin%TYPE;
test1 ADMIN.pwd_admin%TYPE;
    CURSOR c_cursor IS
    SELECT name_admin, pwd_admin FROM ADMIN WHERE name_admin = '&name_admin' and pwd_admin = '&password';
BEGIN
OPEN c_cursor;
DBMS_OUTPUT.PUT_LINE ('8. SE DECONNECTER');
DBMS_OUTPUT.PUT_LINE ('S authentifier');
DBMS_OUTPUT.PUT_LINE ('* login');
DBMS_OUTPUT.PUT_LINE ('* password');
FETCH c_cursor into test , test1;
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
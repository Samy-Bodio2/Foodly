set serveroutput on;
DECLARE
    CURSOR c_cursor IS
    SELECT name_admin, pwd_admin FROM ADMIN WHERE name_admin = '&name_admin';
    v_name_admin ADMIN.name_admin%TYPE;
    v_pwd_admin ADMIN.pwd_admin%TYPE;
    insert_pwd_admin ADMIN.pwd_admin%TYPE;
BEGIN
DBMS_OUTPUT.PUT_LINE('Entrez vous informations:');
    insert_pwd_admin := '&insert_pwd_admin';
    OPEN c_cursor;
    FETCH c_cursor INTO v_name_admin,v_pwd_admin;
    IF v_pwd_admin = insert_pwd_admin THEN
    DBMS_OUTPUT.PUT_LINE('Bonjour!! Vos donnees ont ete mise a jour');
        UPDATE ADMIN SET
        name_admin = '&new_new_admin',
        pwd_admin = '&new_pwd_admin'
        WHERE name_admin = v_name_admin;
    ELSE
        DBMS_OUTPUT.PUT_LINE('Ce compte n existe pas');
    END IF;
END;
/
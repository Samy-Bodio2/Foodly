set serveroutput on;
DECLARE
    CURSOR c_cursor IS
    SELECT username, password FROM Users WHERE username = '&username';
    v_username Users.username%TYPE;
    v_password Users.password%TYPE;
    insert_password Users.password%TYPE;
BEGIN
DBMS_OUTPUT.PUT_LINE('Entrez vous informations:');
    insert_password := '&insert_password';
    OPEN c_cursor;
    FETCH c_cursor INTO v_username,v_password;
    IF v_password = insert_password THEN
    DBMS_OUTPUT.PUT_LINE('Bonjour!! Vos donnees ont ete mise a jour');
        UPDATE Users SET
        username = '&username',
        password = '&password'
        WHERE username = v_username;
    ELSE
        DBMS_OUTPUT.PUT_LINE('Ce compte n existe pas');
    END IF;
END;
/


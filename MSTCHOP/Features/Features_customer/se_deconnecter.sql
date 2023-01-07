DECLARE
essai Users.username%TYPE;
essai1 Users.password%TYPE;
    CURSOR a_cursor IS
    SELECT username, password FROM Users WHERE username = '&username' and password = format1('&password');
BEGIN
OPEN a_cursor;
FETCH a_cursor into essai , essai1;
IF a_cursor%found THEN
DBMS_OUTPUT.PUT_LINE ('Deconnecter !');
END IF;
END;
/

@Procedure/Case
DECLARE
essai ADMIN.name_admin%TYPE;
essai1 ADMIN.pwd_admin%TYPE;
    CURSOR c_cursor IS
    SELECT name_admin, pwd_admin FROM ADMIN WHERE name_admin = '&name_admin' and pwd_admin = format1('&password');
BEGIN
OPEN c_cursor;
FETCH c_cursor into essai , essai1;
IF c_cursor%found THEN
DBMS_OUTPUT.PUT_LINE ('Deconnecter !');
END IF;
END;
/

@Procedure/Case
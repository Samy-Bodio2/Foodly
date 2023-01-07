set serveroutput on;
create or replace FUNCTION id_rst(NOM VARCHAR)
return int is
entier INT;
BEGIN
select id_resto
into entier
FROM restaurant
WHERE name_resto = NOM;
return entier;
END;
/

DECLARE
course admin%ROWTYPE;
CURSOR login IS
select * from admin
where name_admin='&Name_Admin' AND pwd_admin=format1('&Password');
idrestaurant int := id_rst('&Name_of_the_Update_restaurant');
BEGIN
OPEN login;
IF login%notfound THEN
DBMS_OUTPUT.PUT_LINE('null');
ELSE 
UPDATE restaurant
set
name_resto = '&Name_Resto',
Description = '&Description',
name_employee = '&Name_employee',
phone_number = &phone_number,
resto_address = '&Restaurant_Adress'
where id_resto = idrestaurant;
end if;
END;
/
DECLARE
cour admin%ROWTYPE;
CURSOR login IS
select * from admin
where name_admin='&Name_Admin' AND pwd_admin=format1('&Password');
id_menus int := id_menu('&Name_Menu_Title');
BEGIN
OPEN login;
IF login%notfound THEN
DBMS_OUTPUT.PUT_LINE('null');
ELSE 
UPDATE Menu
set
Menu_title = '&Menu_title',
Menu_description = '&Menu_description',
Menu_price = '&Menu_price',
Menu_date = TO_DATE('&Menu_date', 'DD/MM/YYYY'),
Menu_Qty = '&Menu_Qty',
id_dish =
id_seculant =
id_garnish =
id_resto = 
id_config = 
where id_menu = id_menus;
end if;
END;
/
 
 SELECT * FROM Menu;

@Features/Features_admin/Menu_admin
SET SERVEROUTPUT ON;
DECLARE
CURSOR menu IS 
SELECT menu_title,menu_price,menu_description,Menu_Qty,r.name_resto 
from menu m,restaurant r
PROCEDURE Menu_Jour as
v.Menu_title menu.menu_title%ROWTYPE;
v.Menu_price menu.menu_price%ROWTYPE;
v.Menu_description menu.menu_description%ROWTYPE;
v.Menu_Qty menu.Menu_Qty%ROWTYPE;
v.name_resto menu.name_resto%ROWTYPE;
BEGIN
OPEN menu;
LOOP
FETCH menu INTO v.Menu_title,v.Menu_price,v.Menu_description,v.Menu_Qty,v.name_resto;
EXIT WHEN menu%NOTFOUND;
DBMS_OUTPUT.PUT_LINE('Nom Menu : 'v.Menu_title||' '||
'Price Menu :  '||v.Menu_price||'FCFA'||' '||
v.Menu_description||' '||
'Quantity:  '||v.Menu_Qty||' '||
'Restaurant Name : 'v.name_resto);
END LOOP;
CLOSE menu;
END Menu_Jour;
BEGIN
Menu_Jour;
END;
/
---ANGELE

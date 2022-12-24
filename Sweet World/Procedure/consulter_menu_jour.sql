set serveroutput on;
DECLARE
CURSOR menu IS
select Menu_title,Menu_price,Menu_Qty,R.Name_resto from Menu M
JOIN Restaurant R
on M.id_resto = R.id_resto;
PROCEDURE consult_Menu_Jour AS
V_menu_titre Menu%ROWTYPE;
V_menu_price Menu%ROWTYPE;
V_menu_qty Menu%ROWTYPE;
V_resto_nom Restaurant%ROWTYPE; 
BEGIN 
OPEN menu;
LOOP
FETCH menu into V_menu_titre.Menu_title,V_menu_price.Menu_price,V_menu_qty.Menu_Qty,V_resto_nom.Name_resto;
    EXIT WHEN menu%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Nom du Menu: '||V_menu_titre.Menu_title||'  '||'Prix du Menu: '||V_menu_price.Menu_price
    ||'FCFA'||'  '||'Quantite restante: '||V_menu_qty.Menu_Qty||'  '||'Restaurant: '||V_resto_nom.Name_resto);
    DBMS_OUTPUT.PUT_LINE('---------------------------------------------------------------------------------------------------');
END LOOP;
CLOSE menu;
END;
BEGIN
    consult_Menu_Jour;
END;
/
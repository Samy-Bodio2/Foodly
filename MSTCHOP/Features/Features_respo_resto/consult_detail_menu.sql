DECLARE
CURSOR menu IS
select Menu_title,Menu_price,Menu_Qty,R.Name_resto,d.Name_dish,c.Name_garnish,s.Name_Seculant
from Menu M
JOIN Restaurant R
on M.id_resto = R.id_resto
JOIN dish d 
ON d.id_dish = M.id_dish 
JOIN SECULANT s 
ON s.id_seculant = M.id_seculant 
JOIN Garnish c 
ON c.id_garnish = M.id_garnish;
PROCEDURE consult_Menu_Jours AS
V_menu_titre Menu%ROWTYPE;
V_menu_price Menu%ROWTYPE;
V_menu_qty Menu%ROWTYPE;
V_resto_nom Restaurant%ROWTYPE; 
v_Name_dish Dish%ROWTYPE;
v_Name_garnish Garnish%ROWTYPE;
v_Name_Seculant Seculant%ROWTYPE;  
BEGIN 
OPEN menu;
LOOP
FETCH menu into V_menu_titre.Menu_title,V_menu_price.Menu_price,V_menu_qty.Menu_Qty,V_resto_nom.Name_resto,v_Name_dish.Name_dish,v_Name_garnish.Name_garnish,v_Name_Seculant.Name_Seculant;
    EXIT WHEN menu%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Nom du Menu: '||V_menu_titre.Menu_title||' | '||'Prix du Menu: '||V_menu_price.Menu_price
    ||' | '||'Quantite restante: '||V_menu_qty.Menu_Qty||' | '||'Restaurant: '||V_resto_nom.Name_resto||' | '||'Plat: '||v_Name_dish.Name_dish
    ||' | '||'Plat: '||v_Name_garnish.Name_garnish||' | '||'Plat: '||v_Name_Seculant.Name_Seculant);
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------');
END LOOP;
END;
BEGIN
    consult_Menu_Jours;
END;
/

@Features/Features_respo_resto/Menu_respo_resto_con
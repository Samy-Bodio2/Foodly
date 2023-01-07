DECLARE
CURSOR histo IS
SELECT 
R.name_resto ,
co.first_name,
co.last_name,
M.Menu_title,
M.Menu_price,
d.Name_Dish,
c.Name_garnish,
s.Name_seculant,
M.Menu_Qty,
O.order_date
FROM Orders O
JOIN Restaurant R
ON R.id_resto = O.id_resto
JOIN Users U
ON R.id_user = U.id_user
JOIN Customers co
ON co.id_user = U.id_user
JOIN Menu M
ON M.id_resto = R.id_resto
JOIN dish d 
ON d.id_dish = M.id_dish 
JOIN SECULANT s 
ON s.id_seculant = M.id_seculant 
JOIN Garnish c 
ON c.id_garnish = M.id_garnish;
WHERE U.username ='&ENTER_YOUR_NAME' and U.password = format1('&Password');

PROCEDURE historique AS
v_resto_nom Restaurant%ROWTYPE; 
v_first_name Customers%ROWTYPE;
v_last_name Customers%ROWTYPE;
v_menu_titre Menu%ROWTYPE;
v_menu_prix Menu%ROWTYPE;
v_dish Dish%ROWTYPE;
v_garnish Garnish%ROWTYPE;
v_seculant Seculant%ROWTYPE;
v_quantity Menu%ROWTYPE;
v_order_date Orders%ROWTYPE; 
BEGIN 
OPEN histo;
LOOP
FETCH resto into V_resto_nom.Name_resto,V_Description.Description,V_email.email,V_phone_number.phone_number,V_resto_address.resto_address;
    EXIT WHEN histo%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Nom du Restaurant: '||V_resto_nom.Name_resto||'  '||'Sa description: '||V_Description.Description
    ||'  '||'Email: '||V_email.email||'  '||'Phone Number: '||V_phone_number.phone_number||'  '||'Adresse: '||V_resto_address.resto_address);
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------------------------------------------------------------------------------------');
END LOOP;
END;
BEGIN
    consulter_les_restaurants;
END;
/

@Features/Features_admin/Menu_admin
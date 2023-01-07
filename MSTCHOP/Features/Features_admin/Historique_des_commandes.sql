DECLARE
CURSOR resto IS
SELECT 
R.name_resto,
O.order_date,
R.phone_number,
R.resto_address,
M.Menu_title,
M.Menu_price,
M.Menu_date,
M.Menu_Qty,
U.username,

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
PROCEDURE consulter_les_restaurants AS
V_resto_nom Restaurant%ROWTYPE; 
V_Description Restaurant%ROWTYPE;
V_email Restaurant%ROWTYPE;
V_phone_number Restaurant%ROWTYPE;
V_resto_address  Restaurant%ROWTYPE; 
BEGIN 
OPEN resto;
LOOP
FETCH resto into V_resto_nom.Name_resto,V_Description.Description,V_email.email,V_phone_number.phone_number,V_resto_address.resto_address;
    EXIT WHEN resto%NOTFOUND;
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



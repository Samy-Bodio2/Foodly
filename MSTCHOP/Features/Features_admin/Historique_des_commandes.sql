SELECT 
R.name_resto,
O.order_date,
R.phone_number,
R.resto_address,
M.Menu_title,
M.Menu_price,
M.Menu_date,
M.Menu_Qty,
U.username
FROM Orders O
JOIN Restaurant R
ON R.id_resto = O.id_resto
JOIN Users U
ON R.id_user = U.id_user
JOIN Menu M
ON M.id_resto = R.id_resto
WHERE U.username ='&ENTER_YOUR_NAME' and U.password = format1('&Password');


@Features/Features_admin/Menu_admin
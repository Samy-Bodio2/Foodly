SELECT 
order_date,
R.name_resto,
R.phone_number,
R.resto_address,
M.Menu_title,
M.Menu_price,
M.Menu_date,
M.Menu_Qty,
A.name_admin
FROM Orders O
JOIN Restaurant R
ON R.id_resto = O.id_resto
JOIN Users U
ON R.id_user = U.id_user
JOIN ADMIN A
ON A.id_admin = U.id_admin
JOIN Menu M
ON M.id_resto = R.id_resto
WHERE A.name_admin ='&ENTER_YOUR_NAME';


--------------------samy bodio
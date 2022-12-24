SELECT 
order_date,
R.name_resto,
R.phone_number,
R.resto_address,
U.username
FROM Orders O
JOIN Restaurant R
ON R.id_resto = O.id_resto
JOIN Users U
ON R.id_user = U.id_user
WHERE U.username ='&ENTER_YOUR_NAME';
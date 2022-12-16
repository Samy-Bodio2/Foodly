SELECT * FROM Orders O
JOIN Restaurant R
ON R.id_resto = O.id_resto
JOIN Users U
ON R.id_user = U.id_user
WHERE U.username ='&ENTER_YOUR_NAME';
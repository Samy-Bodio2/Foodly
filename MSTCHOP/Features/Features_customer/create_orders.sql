DECLARE
PROCEDURE operation
AS
    varnomFonc int := id_cust('&Enter_Your_Username');
BEGIN
    DELETE FROM Panier
    WHERE id_cust = varnomFonc;
END;
BEGIN
insert into Orders(id_order,order_date,id_resto,id_panier)
VALUES
(id_order_seq.nextval,SYSDATE,nom_restaurant('&Nom_du_restaurant'),idpan('&Enter_Your_User_Name'));
operation;
END;
/

SELECT 
U.username "Nom de l'utilisateur",
M.Menu_title "Nom du menu",
M.Menu_price + M.Menu_price * c.marge "Prix du plat",
O.order_date "Date de commande",
R.name_resto "Nom du restaurant"
FROM Orders O
JOIN Restaurant R
ON R.id_resto = O.id_resto
JOIN Users U
ON R.id_user = U.id_user
JOIN Menu M
ON M.id_resto = R.id_resto
JOIN Config c
ON c.id_config = M.id_config;

@Features/Features_customer/Menu_customer







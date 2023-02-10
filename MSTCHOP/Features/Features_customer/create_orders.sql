/*DECLARE
PROCEDURE operation
AS
    varnomFonc int := id_cust('&Enter_Your_Username');
BEGIN
    DELETE FROM Panier
    WHERE id_cust = varnomFonc;
END;
*/
BEGIN
insert into Orders(id_order,order_date,id_panier)
VALUES
(id_order_seq.nextval,SYSDATE,idpan('&Enter_Your_User_Name'));
--operation;
END;
/

SELECT 
DISTINCT U.username "Nom de l'utilisateur",
O.order_date "Date de commande",
R.Name_resto,
M.Menu_title
FROM Orders O
JOIN Panier p 
ON(p.id_panier = c.id_panier)
JOIN CHOIX c 
ON(c.id_panier = p.id_panier)
JOIN Menu m 
ON(r.id_resto = m.id_resto)
JOIN Restaurant R
ON R.id_resto = O.id_resto
JOIN Users U
ON (R.id_user = U.id_user)
JOIN Customers cu 
ON(p.id_cust = cu.id_cust);


@Features/Features_customer/Menu_customer







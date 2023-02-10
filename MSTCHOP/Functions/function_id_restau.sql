CREATE OR REPLACE FUNCTION id_restau(nom VARCHAR)
RETURN INT IS
CURSOR idresto IS
SELECT r.id_resto 
from Restaurant r
JOIN Menu m 
ON(r.id_resto = m.id_resto)
JOIN CHOIX c 
ON(c.id_panier = c.id_panier)
JOIN Panier p 
ON(p.id_panier = c.id_panier)
JOIN Customers cu 
ON(p.id_cust = cu.id_cust)
where Name_resto = nom;
entier INT;
BEGIN
OPEN idresto;
FETCH idresto into entier;
RETURN entier;
END;
/

create or replace FUNCTION id_rst(NOM VARCHAR)
return int is
entier INT;
BEGIN
select id_resto
into entier
FROM restaurant
WHERE name_resto = NOM;
return entier;
END;
/
SELECT
DISTINCT u.username "Nom de l'utilisateur", 
m.Menu_title "Titre du menu",
co.first_name||co.last_name "Nom complet ",
m.Menu_price "Prix ",
m.Menu_Qty "Quantite",
d.Name_dish "Nom du plat",
s.Name_Seculant "Nom sdu seculant",
c.Name_garnish "Nom du complement ",
o.order_date "Date de commande",
r.name_resto "Nom du restaurant"
FROM Orders o
JOIN panier p
ON p.id_panier = o.id_panier
JOIN customers co 
ON co.id_cust = p.id_cust
JOIN users u
ON u.id_user = co.id_user
JOIN restaurant r 
ON u.id_user = r.id_user
JOIN Menu m
ON r.id_resto = m.id_resto
JOIN dish d 
ON d.id_dish = m.id_dish 
JOIN SECULANT s 
ON s.id_seculant = m.id_seculant 
JOIN Garnish c 
ON c.id_garnish = m.id_garnish
WHERE username = '&username' AND password = format1('&password');

@Features/Features_customer/Menu_customer
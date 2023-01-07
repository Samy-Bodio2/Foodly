SELECT 
m.Menu_title,
c.first_name||c.last_name,
m.Menu_price,
m.Menu_date,
m.Menu_Qty,
d.Name_dish,
s.Name_Seculant,
g.Name_garnish,
m.order_date,
r.name_resto
FROM Orders o
JOIN panier p
ON p.id_panier = o.id_panier
JOIN customers c 
ON c.id_cust = p.id_cust
JOIN users u
ON u.id_user = c.id_user
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
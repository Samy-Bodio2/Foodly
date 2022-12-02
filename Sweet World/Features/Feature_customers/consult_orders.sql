SELECT c.first_name||' '||c.last_name "Nom complet",
       m.Menu_title "Nom du menu",
       m.Menu_price * co.marge + m.Menu_price + co.freight_costs "Prix total",
       cpm.Quantity "Quantite",
       d.Name_dish||' '||com.Name_complement||' '||s.Name_Seculant "Compo plat",
       o.Order_date "Date commande" ,
       r.name_resto "Nom du resto"
FROM customers c 
JOIN panier p 
ON(c.id_cust = p.id_cust)
JOIN Control_Panier_Menu cpm
ON(p.id_panier = cpm.id_panier)
JOIN Menu m 
ON(cpm.id_menu = m.id_menu)
JOIN Config co 
ON(m.id_config = co.id_config)
JOIN Dish d
ON(m.id_dish = d.id_dish)
JOIN Complement com 
ON(m.id_complement = com.id_complement)
JOIN Seculant s 
ON(m.id_seculant = s.id_seculant)
JOIN Restaurant r 
ON(m.id_resto = r.id_resto)
JOIN Orders o 
ON(r.id_resto = o.id_resto)
WHERE c.id_cust=&id_cust;
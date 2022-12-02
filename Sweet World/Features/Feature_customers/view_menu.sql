SELECT m.Menu_title "Nom du menu",
       d.Name_dish||' '||com.Name_complement||' '||s.Name_Seculant "Compo plat",
       m.Menu_price * co.marge + m.Menu_price + co.freight_costs "Prix total",
       Menu_qty "Quantite"
FROM menu m
JOIN Config co 
ON(m.id_config = co.id_config)
JOIN Dish d
ON(m.id_dish = d.id_dish)
JOIN Complement com 
ON(m.id_complement = com.id_complement)
JOIN Seculant s
ON(m.id_seculant = s.id_seculant);

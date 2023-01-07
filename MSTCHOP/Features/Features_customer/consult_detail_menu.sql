SELECT r.Name_resto "Nom du restaurant",
       m.Menu_title "Nom du menu",
       d.Name_dish||' '||g.Name_garnish||' '||s.Name_Seculant "Compo plat",
       m.Menu_price * co.marge + m.Menu_price "Prix total",
       Menu_qty "Quantite"
FROM menu m
JOIN Restaurant r
ON(m.id_resto = r.id_resto)
JOIN Config co 
ON(m.id_config = co.id_config)
JOIN Dish d
ON(m.id_dish = d.id_dish)
JOIN Garnish g 
ON(m.id_garnish = g.id_garnish)
JOIN Seculant s
ON(m.id_seculant = s.id_seculant);

@Features/Features_customer/Menu_customer
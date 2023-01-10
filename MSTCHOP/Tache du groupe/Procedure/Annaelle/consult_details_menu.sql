SELECT Menu_title,
       Menu_description,
       Menu_price,
       Menu_date,
       Menu_Qty,
       d.Name_dish,
       s.Name_Seculant,
       g.Name_garnish
FROM Menu m
   JOIN Dish d
   ON m.id_dish = d.id_dish
   JOIN Garnish g
   ON g.id_garnish= m.id_garnish
   JOIN Seculant s
   ON s.id_seculant = m.id_seculant
   JOIN Restaurant r
   ON r.id_resto = m.id_resto
WHERE m.Menu_title = '&Menu_title';





























































































































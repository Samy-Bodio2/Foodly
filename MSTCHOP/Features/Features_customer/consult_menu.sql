SELECT m.Menu_title "Nom du menu",
       m.Menu_price * co.marge + m.Menu_price "Prix total",
       m.Menu_qty "Quantite"
FROM menu m
JOIN Config co 
ON(m.id_config = co.id_config);


@Features/Features_customer/Menu_customer
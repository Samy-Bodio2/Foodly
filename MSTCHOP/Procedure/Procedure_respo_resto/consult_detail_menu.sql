select Menu_title,Menu_Qty,
Menu_description,
Menu_price,
Menu_date,
Menu_Qty,
id_dish,
id_seculant,
id_garnish,
name_resto,
id_config  
from menu m
join restaurants r
on r id_resto = m id_resto;
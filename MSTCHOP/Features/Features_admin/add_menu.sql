SELECT d.Name_dish, s.Name_Seculant ,c.Name_garnish
FROM MENU m 
JOIN dish d 
ON d.id_dish = M.id_dish 
JOIN SECULANT s 
ON s.id_seculant = M.id_seculant 
JOIN Garnish c 
ON c.id_garnish = M.id_garnish; 

INSERT INTO Menu(id_menu, Menu_title,Menu_description,Menu_price, Menu_date,Menu_Qty,id_dish,id_seculant,id_garnish,id_resto,id_config)VALUES
(id_menu_seq.nextval, '&Menu_Title','&Menu_Description',&Price_of_Menu,
SYSDATE,&Quantity_Menu,id_dish('&dish_name'),id_seculant('&seculant_name'),id_garnish('&Name_garnish'),'',1);

@Features/Features_admin/Menu_admin
INSERT INTO Menu(id_menu, Menu_title,Menu_description,Menu_price, Menu_date,Menu_Qty,id_dish,id_seculant,id_garnish,id_resto,id_config)VALUES
(id_menu_seq.nextval, '&Menu_Title','&Menu_Description',&Price_of_Menu,
SYSDATE,&Quantity_Menu,id_dish('&dish_name'),id_seculant('&seculant_name'),id_garnish('&Name_garnish'),id_restau('&Name_of_the_restaurant'),1);

@Features/Features_admin/Menu_admin
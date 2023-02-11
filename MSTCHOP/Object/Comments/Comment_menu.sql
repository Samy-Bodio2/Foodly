COMMENT ON TABLE Menu
IS 'Permet aux restaurants dajouter les menus'


COMMENT ON COLUMN Menu.id_menu  
IS 'Primary key of Menu table.'

COMMENT ON COLUMN Menu.Menu_Title  
IS 'Titre du menu.'

COMMENT ON COLUMN Menu.Menu_description
IS 'Description du menu.'

COMMENT ON COLUMN Menu.Menu_price  
IS 'Prix du menu.'

COMMENT ON COLUMN Menu.Menu_date  
IS 'Date creation du menu.'

COMMENT ON COLUMN Menu.Menu_Qty 
IS 'Quantité du menu.'

COMMENT ON COLUMN Menu.id_dish 
IS 'Foreign key of Menu reference of Dish table.'

COMMENT ON COLUMN Menu.id_seculant  
IS 'Foreign key of Menu table reference of Seculant table.'

COMMENT ON COLUMN Menu.id_complement 
IS 'Foreign key of Menu table reference of Complement table.'

COMMENT ON COLUMN Menu.id_resto  
IS 'Foreign key of Menu table reference of Restaurant table.'

COMMENT ON COLUMN Menu.id_config 
IS 'Foreign key of Menu table reference of Config table.'
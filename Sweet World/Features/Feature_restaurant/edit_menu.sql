 UPDATE Menu
SET       
    Menu_title = '&Menu_title' ,      
    Menu_description = '&Menu_description' ,
    Menu_price   = &Menu_price ,          
    Menu_date       = '&Menu_date' ,
    Menu_Qty         = '&Menu_Qty' ,
    id_dish          =&id_dish ,
    id_seculant      = &id_seculant ,
    id_complement    = &id_complement ,
    id_resto         = &id_resto ,
    id_config     = &id_config
WHERE id_menu=&id_menu;
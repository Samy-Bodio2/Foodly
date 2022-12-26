UPDATE PROCEDURE menu_update
(v_id_menu          IN INT     ,
v_ Menu_title       IN VARCHAR(25) , 
v_Menu_description  IN VARCHAR(80),
v_Menu_price        IN NUMBER ,
v_Menu_date         IN DATE  ,
v_Menu_Qty          IN VARCHAR(50),
v_id_dish           IN INT,  
v_id_seculant       IN INT,
v_ id_complement    IN INT,
v_id_resto          IN INT,
v_id_config         IN INT)
IS 
v_chaine            VARCHAR(30)='Modifier votre Menu '
BEGIN
DBMS_OUTPUT.PUT_LINE(v_chaine);
END ;
UPDATE Menu SET
 Menu_title          = v_ Menu_title ,      
    Menu_description = v_Menu_description ,
    Menu_price       = v_Menu_price,          
    Menu_date        = v_Menu_date ,
    Menu_Qty         =v_Menu_Qty,
    id_dish          =v_id_dish,
    id_seculant      = v_id_seculant,
    id_complement    = v_ id_complement ,
    id_resto         = v_id_resto,
    id_config        = v_id_config
WHERE id_menu        =v_id_menu;
END ;
/
-------******BY TATSINKOU******-------
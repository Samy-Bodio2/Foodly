
CREATE PROCEDURE consult_Detaille_Menu IS 
V_Menu_title         Menu.Menu_title%TYPE;
V_Descrition_Menu    Menu.Menu_description%TYPE;
V_menu_price         Menu.Menu_price%TYPE;
v_Menu_date          Menu.Menu_date%TYPE;
v_Menu_Qty           Menu.Menu_Qty%TYPE;
V_name_dish          dish.Name_dish%TYPE;
V_name_seculant      Seculant.Name_Seculant%TYPE;
V_palt_complement    complement.Name_complement%TYPE;
V_name_Resro         restaurant.name_resto%TYPE;
BEGIN 
SELECT 
Menu_title,
Menu_description,
Menu_price,
Menu_date,
Menu_Qty,
Name_dish,
Name_Seculant
Name_complement,
name_resto
INTO 
V_Menu_title  ,       
V_Descrition_Menu ,   
V_menu_price   ,   
v_Menu_date ,        
v_Menu_Qty  ,        
V_name_dish   ,       
V_name_seculant ,    
V_palt_complement ,  
V_name_Resro 
FROM Menu
JOIN Dish
ON dish.id_dish = Menu.id_dish
JOIN Seculant 
ON Seculant.id_seculant = Menu.id_seculant
JOIN complement
ON complement.id_complement = menu.id_complement
JOIN restaurant
ON restaurant.id_resto = Menu.id_resto;
END;
/
BEGIN
consult_Detail_Menu;
END;
/

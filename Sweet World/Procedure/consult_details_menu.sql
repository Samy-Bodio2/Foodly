CREATE PROCEDURE consult_details_menu 
r_id_menu            restaurant.restaurant_id%TYPE;
r_Menu_title         restaurant.restaurant_title%TYPE;
r_Menu_descrption    restaurant.restaurant_description%TYPE;
r_Menu_price         restaurant.restaurant_price%TYPE;
r_Menu_date          restaurant.restaurant_date%TYPE;
r_Menu_Qty           restaurant.restaurant_quantity%TYPE;
r_id_dish            restaurant.restaurant_id%TYPE;
r_id_complement      restaurant.restaurant_id%TYPE;
r_id_secilant        restaurant.restaurant_id%TYPE;
r_Name_dish          restaurant.restaurant_name%TYPE;
r_Name_complement    restaurant.restaurant_name%TYPE;
r_Name_seculant      restaurant.restaurant_name%TYPE;
IS 
BEGIN
SELECT
    id_menu,           
    Menu_title,         
    Menu_descrption,   
    Menu_price,        
    Menu_date,         
    Menu_Qty,           
    id_dish,            
    id_complement,     
    id_secilant,       
    Name_dish,          
    Name_complement ,  
    Name_seculant     
FROM  Menu;

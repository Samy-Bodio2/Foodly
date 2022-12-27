/*CREATE PROCEDURE consult_restaurant IS 
r_id_restaurant      restaurant.restaurant_id%TYPE;
r_Name_resto         restaurant.restaurant_name%TYPE;
r_Name_employees     restaurant.restaurant_name%TYPE;
r_Description        restaurant.restaurant_descrption%TYPE;
r_Phone_number       restaurant.restaurant_number%TYPE;
r_Resto_adresse      restaurant.restaurant_adresse%TYPE;
r_Date_res_created   restaurant.restaurant_date%TYPE;
r_id_user            restaurant.restaurant_id%TYPE;
BEGIN 
SELECT 
    id_restaurant,
    Name_resto,
    Name_employees,
    Description,
    Phone_number,
    Date_res_created,
    id_user
FROM  restaurant; */

-- CREATE PROCEDURE consult_restaurant 
--     (
--         in_r_id_restaurant int 
       
--         r_Name_resto         
--         r_Name_employees     
--         r_Description       
--         r_Phone_number       
--         r_Resto_adresse      
--         r_Date_res_created   
--         r_id_user            
--     )
--     IS
--     r_id_restaurant      restaurant.restaurant_id%TYPE;
--     r_Name_resto         restaurant.restaurant_name%TYPE;
--     r_Name_employees     restaurant.restaurant_name%TYPE;
--     r_Description        restaurant.restaurant_descrption%TYPE;
--     r_Phone_number       restaurant.restaurant_number%TYPE;
--     r_Resto_adresse      restaurant.restaurant_adresse%TYPE;
--     r_Date_res_created   restaurant.restaurant_date%TYPE;
--     r_id_user            restaurant.restaurant_id%TYPE;
-- BEGIN 

-- SELECT * INTO
--     r_id_restaurant,
--     r_Name_resto,
--     r_Name_employees,
--     r_Description,
--     r_Phone_number,
--     r_Resto_adresse,
--     r_Date_res_created,
--     r_id_user,

    
-- FROM  restaurant
-- WHERE
-- r_id_restaurant    = id-restaurant,
--     r_Name_resto      =  Name_restaurant,
--     r_Name_employees   =  Name_employees,
--     r_Description     = Description,
--     r_Phone_number     = Phone_number,  
--     r_Resto_adresse      = r_Resto_adresse,
--     r_Date_res_created   = Date_res_created,
--     r_id_user            = id_user

-- DBMD_OUTPUT.PUT_LINE(r_id_restaurant||''||r_Name_resto||''||r_Name_employees||''||r_Description||''||r_Phone_number||''||r_Resto_adresse||''||r_Date_res_created||''||r_id_user )
-- END;





--OK
--ou alors, on peut aussi faire ceci

SELECT Name_resto,
Description,
Phone_number,
resto_address,
Date_res_created
From Restaurant;

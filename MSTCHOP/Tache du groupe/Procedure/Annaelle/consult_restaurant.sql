SELECT  name_resto ,  
      Description,  
      email ,         
      phone_number,  
      resto_address  
From Restaurant;

/*CREATE PROCEDURE consult_restaurant 
r_id_restaurant      restaurant.restaurant_id%TYPE;
r_Name_resto         restaurant.restaurant_name%TYPE;
r_Name_employees     restaurant.restaurant_name%TYPE;
r_Description        restaurant.restaurant_descrption%TYPE;
r_Phone_number       restaurant.restaurant_number%TYPE;
r_Resto_adress      restaurant.restaurant_adresse%TYPE;
r_Date_res_created   restaurant.restaurant_date%TYPE;
r_id_user            restaurant.restaurant_id%TYPE;
IS
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

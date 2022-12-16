create procedure add_restaurant IS
r_id_restaurant      restaurant.restaurant_id%TYPE;
r_Name_resto         restaurant.restaurant_name%TYPE;
r_Name_employees     restaurant.restaurant_name%TYPE;
r_Description        restaurant.restaurant_descrption%TYPE;
r_Phone_number       restaurant.restaurant_number%TYPE;
r_Resto_adresse      restaurant.restaurant_adresse%TYPE;
r_Date_res_created   restaurant.restaurant_date%TYPE;
r_id_user            restaurant.restaurant_id%TYPE;
BEGIN 
  INSERT INTO restaurant
  (
    id_restaurant,
    Name_resto,
    Name_employees,
    Description,
    Phone_number,
    Date_res_created,
    id_user
  )
  VALUES 
  (
    r_id_restaurant ,
    r_Name_resto,
    r_Name_employees,
    r_Description,
    r_Phone_number,
    r_Resto_adresse,
    r_Date_res_created ,
    r_id_user          
  );
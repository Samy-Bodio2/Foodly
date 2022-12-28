CREATE TABLE RESTO AS SELECT * FROM Restaurant;
create procedure add_restaurant_authentification  IS
r_id_restaurant      Restaurant.restaurant_id%TYPE;
r_Name_resto         Restaurant.restaurant_name%TYPE;
r_Name_employees     Restaurant.restaurant_name%TYPE;
r_Description        Restaurant.restaurant_descrption%TYPE;
r_Phone_number       Restaurant.restaurant_number%TYPE;
r_Resto_adresse      Restaurant.restaurant_adresse%TYPE;
r_Date_res_created   Restaurant.restaurant_date%TYPE;
r_id_user            Restaurant.restaurant_id%TYPE;
BEGIN 
  INSERT INTO Restaurant
  (
    [id_restaurant],
     [Name_resto],
     [Name_employees],
     [Description],
     [Phone_number],
     [Date_res_created],
     [id_user]
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
  END;
  /
  ---- Fotso ---
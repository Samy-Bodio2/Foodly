
create  or replace procedure add_restaurant_authentification  IS
DECLARE
test ADMIN.name_admin%TYPE;
test1 ADMIN.pwd_admin%TYPE;
    CURSOR c_cursor IS
    SELECT name_admin, pwd_admin FROM ADMIN WHERE name_admin = '&name_admin' and pwd_admin = '&password';
r_id_restaurant      Restaurant.id_resto%TYPE;
r_Name_resto         Restaurant.Name_resto%TYPE;
r_Name_employees     Restaurant.Name_employees%TYPE;
r_Description        Restaurant.Description%TYPE;
r_Phone_number       Restaurant.Phone_number%TYPE;
r_Resto_adresse      Restaurant.Resto_adresse%TYPE;
r_Date_res_created   Restaurant.Date_res_created%TYPE;

BEGIN 
  INSERT INTO Restaurant
  (
    id_resto,
     Name_resto,
     Name_employees,
     Description,
     Phone_number,
     Date_res_created,
     id_user
  )
  VALUES 
  (
    r_id_resto_seq.nextval ,
    r_Name_resto,
    r_Name_employees,
    r_Description,
    r_Phone_number,
    r_Resto_adresse,
    r_Date_res_created ,
    r_id_user_seq.nextval          
  );
  END;
  /
  ---- Fotso ---
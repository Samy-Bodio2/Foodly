
DECLARE
r_id_user Users.id_user%type;
  PROCEDURE add_restaurant 
  AS
  BEGIN
   SELECT 
      id_user 
    INTO 
       r_id_user
    FROM 
       Restaurant r
    JOIN 
       Users u
    ON  
       (r.id_user=u.id_user)
    WHERE
        username='&Enter_your_username'
    AND 
        password='&Enter_your_password'

    INSERT INTO
    (
        id_resto,   
      name_resto ,  
      Description,  
      email ,         
      phone_number,  
      resto_address,   
      id_user            
    )
    VALUES
    (
      
        id_resto_seq.nextval,'&name_resto',
                             '&description', 
                            '&email',
                            '&phone_number',
                            '&resto_address',
                              r_id_user
    )

END;
BEGIN
add_restaurant;
END;
/



/*
SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE Add_Restaurant
  r_id_resto         IN	INT	,	
  r_Name_resto      IN	VARCHAR2(25),
  r_Name_employees  IN	VARCHAR2(25),
  r_Description     IN	VARCHAR2(25),
  r_Phone_number    IN INT,
  r_Resto_adress   IN VARCHAR2(25),
  r_Date_res_created IN DATE,
  r_id_user           IN INT
                                        
   IS
        l_msg VARCHAR2(100);
    BEGIN
      INSERT INTO Restaurant
      ( 
        id_resto,
         Name_resto,
         Name_employees,
         Description,
         Phone_number,
         Resto_adress,
         Date_res_created,
         id_user
      )
    VALUES 
  (
    
    r_Name_resto,
    r_Name_employees,
    r_Description,
    r_Phone_number,
    r_Resto_adress,
    r_Date_res_created ,
    r_id_user          
  )
            SELECT 
            r_id_resto,
            r_Name_resto,
            r_Name_employees,
            r_Description,
            r_Phone_number,
            r_Resto_adress,
            r_Date_res_created,
            r_id_user
       FROM DUAL
      WHERE NOT EXISTS
           (SELECT NULL FROM Restaurant WHERE id_resto = r_id_resto);
    l_msg :=
    CASE 
        WHEN SQL%ROWCOUNT >0 THEN 'restaurant registered'
            ELSE ' restaurant already exists'
         END;
          DBMS.OUTPUT.put_line(l_msg);
 END;
*/












































/*
create procedure add_restaurant 
r_id_restaurant      restaurant.restaurant_id%TYPE;
r_Name_resto         restaurant.restaurant_name%TYPE;
r_Name_employees     restaurant.restaurant_name%TYPE;
r_Description        restaurant.restaurant_descrption%TYPE;
r_Phone_number       restaurant.restaurant_number%TYPE;
r_Resto_adresse      restaurant.restaurant_adresse%TYPE;
r_Date_res_created   restaurant.restaurant_date%TYPE;
r_id_user            restaurant.restaurant_id%TYPE;
IS
BEGIN 
  INSERT INTO restaurant
  (
    
    Name_resto,
    Name_employees,
    Description,
    Phone_number,
    Date_res_created,
    id_user
  )
  VALUES 
  (
    
    r_Name_resto,
    r_Name_employees,
    r_Description,
    r_Phone_number,
    r_Resto_adresse,
    r_Date_res_created ,
    r_id_user          
  );
  END;
 */ 
 
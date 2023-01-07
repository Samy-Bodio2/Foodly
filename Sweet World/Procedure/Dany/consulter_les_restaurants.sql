
--'''''''''''''''''''''''''''''''''''''''''''''''''''''' crating by kenchoung''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''

CREATE or REPLACE PROCEDURE consulter_les_restaurants IS 
V_nom_resto         Restaurant.name_resto%TYPE;
V_phone_resto         Restaurant.phone_number%TYPE;
v_adress_resto      Restaurant.resto_addresso%TYPE;
BEGIN 
SELECT 
name_resto,
phone_number,
resto_addresso
INTO 
V_nom_resto ,         
V_phone_resto ,         
v_adress_resto  
FROM Restaurant
END;
/
BEGIN
consulter_les_restaurants;
END;
/

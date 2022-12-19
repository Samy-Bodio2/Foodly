CREATE OR REPLACE PROCEDURE consult_restaurant
v_id_resto Restaurant.id_resto%TYPE,
v_Restaurant_name Restaurant.name_resto%TYPE,
v_Restaurant_description Restaurant.Description%TYPE,
v_Restaurant_employee Restaurant.name_employee%TYPE,
v_Restaurant_phone Restaurant.phone_number%TYPE,
v_Restaurant_address Restaurant.resto_address%TYPE,
v_Restaurant_date Restaurant.Date_res_created%TYPE,
v_Restaurant_id_user Restaurant.id_user%TYPE
AS
BEGIN
SELECT * FROM Restaurant;
END;
/
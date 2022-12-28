CREATE FUNCTION ValNull(VAR IN VARCHAR)
RETURN VARCHAR IS
conk VARCHAR(20);
BEGIN
    IF VAR IS NULL THEN 
        RETURN VAR;
    ELSE 
        RETURN VAR;
    END IF;
END;
/

DECLARE 
    v_name_dish Dish.Name_dish%type;
BEGIN 
    SELECT Name_dish INTO v_name_dish
    FROM DISH
    WHERE Name_dish = '&Name_dish';

UPDATE Dish
SET 
Name_dish = ValNull('&Name_dish')
WHERE id_dish = &id_dish;
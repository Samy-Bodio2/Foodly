CREATE PROCEDURE consult_Menu_Jour IS 
V_Menu_title         Menu.Menu_title%TYPE;
v_Menu_Qty           Menu.Menu_Qty%TYPE;
BEGIN 
SELECT 
Menu_title,
Menu_Qty
INTO
V_Menu_title ,       
v_Menu_Qty        
FROM Menu
END;
/

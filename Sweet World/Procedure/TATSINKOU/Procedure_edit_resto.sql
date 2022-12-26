UPDATE PROCEDURE resto_update
(v_id_resto        IN INT     ,
v_name_resto       IN VARCHAR(30) , 
v_Description      IN VARCHAR(40),
v_name_employee    IN VARCHAR(20),
v_phone_number     IN INT ,
v_resto_address    IN VARCHAR(50),
v_Date_res_created IN DATE,  
v_id_user          IN INT)
IS 
v_chaine NVARCHAR(30)='Modifier votre Restaurant'
BEGIN
DBMS_OUTPUT.PUT_LINE(v_chaine);
END;
UPDATE Restaurant SET
id_resto            =v_id_resto,
name_resto          =v_name_resto, 
Description         =v_Description,
name_employee       =v_name_employee,
phone_number        =v_phone_number ,
resto_address       =v_resto_address,
Date_res_created    =v_Date_res_created, 
id_user             =v_id_user
WHERE id_resto      =v_id_resto;
END ;/
-------******BY TATSINKOU******-------
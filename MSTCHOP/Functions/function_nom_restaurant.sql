CREATE OR REPLACE FUNCTION nom_restaurant(rst VARCHAR)
RETURN INT IS
CURSOR nom IS
select id_resto from Restaurant where Name_resto = rst;
idrst INT;
BEGIN
OPEN nom;
FETCH nom INTO idrst;
CLOSE nom;
RETURN idrst;
END;
/
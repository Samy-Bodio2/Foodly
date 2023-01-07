DECLARE
BEGIN
    DELETE from Restaurant
    WHERE Name_Resto = '&Name_Resto';
END;
/

@Features/Features_admin/Menu_admin
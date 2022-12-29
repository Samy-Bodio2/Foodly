CREATE OR REPLACE PROCEDURE magie
IS
    valt INT := id_panier_seq.currval;
    QuantityPanier  Control_Panier_Menu.Quantity%TYPE;
    var_id_menu Menu.id_menu%TYPE;

    CURSOR quantPanier IS
    SELECT Quantity from Control_Panier_Menu
    where id_panier = valt;

    CURSOR menuId IS
    SELECT id_menu from Control_Panier_Menu
    where id_panier = valt;
BEGIN
    OPEN quantPanier;
    OPEN menuId;
    FETCH quantPanier INTO QuantityPanier;
    FETCH menuId INTO var_id_menu;
    UPDATE MENU 
    SET Menu_Qty = Menu_Qty - QuantityPanier
    WHERE id_menu = var_id_menu;
END;
/

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

DECLARE
BEGIN
insert into Orders(id_order,order_date,id_resto,id_panier)
VALUES
(id_order_seq.nextval,SYSDATE,nom_restaurant('&Nom_du_restaurant'),id_panier_seq.currval);
magie;
END;
/
set serveroutput on;
CREATE OR REPLACE FUNCTION id_menu(nom VARCHAR)
RETURN INT IS
CURSOR idmen IS
SELECT id_menu from Menu where Menu_title = nom;
entier INT;
BEGIN
OPEN idmen;
FETCH idmen into entier;
RETURN entier;
END;
/

CREATE OR REPLACE FUNCTION CALCUL
RETURN INT IS
    
    valt int not null := id_panier_seq.currval;
    
    CURSOR prix IS
    SELECT Menu_price 
    from Menu M
    join Control_Panier_Menu CPM
    on M.id_menu = CPM.id_menu
    join Panier P
    on P.id_panier = CPM.id_panier
    where P.id_panier =  valt;

    CURSOR Quant IS
    SELECT Quantity
    from Control_Panier_Menu
    where id_panier = valt;

    entier1 int; 
    entier2 int; 
    result int;
BEGIN
    OPEN prix;
    OPEN Quant;
    FETCH prix INTO entier1;
    FETCH Quant INTO entier2;

    result := entier1*entier2;
RETURN result;
END;
/

CREATE OR REPLACE PROCEDURE AFFICHE
AS
valt int not null := id_panier_seq.currval;
CURSOR CP IS
    SELECT Menu_title,Menu_Price
    from Menu M
    join Control_Panier_Menu CPM
    on M.id_Menu = CPM.id_Menu
    join Panier P
    on P.id_panier = CPM.id_panier
    where CPM.id_panier =  valt;
CURSOR CPM IS
    SELECT * from Control_Panier_Menu where id_panier = valt;
    name_menu VARCHAR(50);
    prix_menu INT;
    control Control_Panier_Menu%ROWTYPE;
BEGIN
    OPEN CPM;
    OPEN CP;
    FETCH CP INTO name_menu,prix_menu;
    FETCH CPM INTO control;
    DBMS_OUTPUT.PUT_LINE('Nom du Menu:'||name_menu||'  '||'Quantite du Menu:'||control.Quantity||'  '||'Prix du Menu:'||prix_menu||'  '||'Prix total du Panier:'||CALCUL);
END;
/

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

CREATE OR REPLACE FUNCTION custFonc(varNom VARCHAR)
RETURN INT IS
    valt Users.id_user%TYPE;
    valt2 Customers%ROWTYPE;
    valt3 Users.username%TYPE;

    entier int := id_customers_seq.currval;
    CURSOR iduser IS
    SELECT id_user from Users where username = varNom;

    CURSOR idusername IS
    SELECT U.username from Users U
    JOIN Customers C
    ON C.id_user = U.id_user
    where C.id_user = (
        SELECT id_user from Users where username = varNom
    );

    CURSOR custs IS
    SELECT * from Customers;
BEGIN
    OPEN idusername;
    FETCH idusername INTO valt3;
    IF valt3 = varNom THEN
    OPEN iduser;
    OPEN custs;
    FETCH iduser INTO valt;

    FOR i IN 1..entier LOOP
            FETCH custs INTO valt2;
            EXIT WHEN valt2.id_user = valt;
    END LOOP;
    RETURN valt2.id_cust;
    ELSE
    RETURN 0;
    END if;
END;
/

DECLARE
PROCEDURE operation
AS
    varnomFonc int := custFonc('&Enter_Your_Username');
BEGIN
    DELETE FROM Panier
    WHERE id_cust = varnomFonc;
    DELETE FROM Customers
    WHERE id_cust = varnomFonc;
END;
BEGIN

    INSERT INTO Panier(id_panier,id_cust)VALUES
    (id_panier_seq.nextval,
    id_cust('&Enter_Your_User_Name'));
    INSERT INTO Control_Panier_Menu(id_panier,id_menu,Quantity) VALUES (id_panier_seq.currval,id_menu('&Menu_Title'),&Quantity);
    AFFICHE;
    magie;
    insert into Orders(id_order,order_date,id_resto,id_panier)
    VALUES
    (id_order_seq.nextval,SYSDATE,nom_restaurant('&Nom_du_restaurant'),id_panier_seq.currval);
    operation;
    DBMS_OUTPUT.PUT_LINE('Votre commande a ete passer avec SUCCESS!');
END;
/
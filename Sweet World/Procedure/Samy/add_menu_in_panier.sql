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

CREATE OR REPLACE FUNCTION idutil(nom VARCHAR)
RETURN INT IS
CURSOR iduse IS
SELECT id_user from Users where username = nom;
entier INT;
BEGIN
OPEN iduse;
FETCH iduse into entier;
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

DECLARE
BEGIN
    INSERT INTO Customers(id_cust,first_name,last_name,phone_number,Email,Datecd_cust,Cust_address,id_user)
    VALUES
    (id_customers_seq.nextval,'&first_name','&last_name',&phone_number,'&Email',SYSDATE,'&Cust_address',idutil('&Enter_Your_User_Name'));
        INSERT INTO Panier(id_panier,id_cust)VALUES
    (id_panier_seq.nextval,
    id_customers_seq.currval);
    INSERT INTO Control_Panier_Menu(id_panier,id_menu,Quantity) VALUES (id_panier_seq.currval,id_menu('&Menu_Title'),&Quantity);
    AFFICHE;
    magie;
END;
/
SELECT * FROM Menu;
CREATE OR REPLACE FUNCTION CALCUL
RETURN INT IS
    
    valt int not null := id_panier_seq.currval;
    
    CURSOR prix IS
    SELECT Menu_price 
    from Menu M
    join Choix CPM
    on M.id_menu = CPM.id_menu
    join Panier P
    on P.id_panier = CPM.id_panier
    where P.id_panier =  valt;

    CURSOR Quant IS
    SELECT Quantity
    from Choix
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
    join Choix CPM
    on M.id_Menu = CPM.id_Menu
    join Panier P
    on P.id_panier = CPM.id_panier
    where CPM.id_panier =  valt;
CURSOR CPM IS
    SELECT * from Choix where id_panier = valt;
    name_menu VARCHAR(50);
    prix_menu INT;
    control Choix%ROWTYPE;
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
    QuantityPanier  Choix.Quantity%TYPE;
    var_id_menu Menu.id_menu%TYPE;

    CURSOR quantPanier IS
    SELECT Quantity from Choix
    where id_panier = valt;

    CURSOR menuId IS
    SELECT id_menu from Choix
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
    INSERT INTO Panier(id_panier,id_cust)VALUES
    (id_panier_seq.nextval,
    id_cust('&Enter_Your_User_Name'));
    INSERT INTO Choix(id_panier,id_menu,Quantity) VALUES (id_panier_seq.currval,id_menu('&Menu_Title'),&Quantity);
    AFFICHE;
    magie;
END;
/

SELECT * FROM menu;
@Features/Features_customer/Menu_customer




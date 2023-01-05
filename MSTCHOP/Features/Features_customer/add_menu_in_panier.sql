/*CREATE OR REPLACE PROCEDURE AFFICHE
AS
valt int not null := id_panier_seq.currval;
CURSOR CP IS
    SELECT Menu_title,Menu_Price
    from Menu M
    join Choix C
    on M.id_Menu = C.id_Menu
    join Panier P
    on P.id_panier = C.id_panier
    where C.id_panier =  valt;
CURSOR C IS
    SELECT * from Choix where id_panier = valt;
    name_menu VARCHAR(50);
    prix_menu INT;
    control Choix%ROWTYPE;
BEGIN
    OPEN C;
    OPEN CP;
    FETCH CP INTO name_menu,prix_menu;
    FETCH C INTO control;
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
    INSERT INTO Customers(id_cust,first_name,last_name,phone_number,Email,Datecd_cust,Cust_address,id_user)
    VALUES
    (id_customers_seq.nextval,'&first_name','&last_name',&phone_number,'&Email',SYSDATE,'&Cust_address',idutil('&Enter_Your_User_Name'));
        INSERT INTO Panier(id_panier,id_cust)VALUES
    (id_panier_seq.nextval,
    id_customers_seq.currval);
    INSERT INTO Choix(id_panier,id_menu,Quantity) VALUES (id_panier_seq.currval,id_menu('&Menu_Title'),&Quantity);
    AFFICHE;
    magie;
END;
/
*/
declare


v_id_panier int :=id_panier('&username','&password');

cursor idMenu is 
select id_menu from menu where menu_title = '&menu';
idM int;

begin
open idMenu;
fetch idMenu into idM;

insert into choix(id_panier,id_menu,Quantity)
values (v_id_panier, idM, &quantite);

end;
/

@Features/Features_customer/Menu_customer
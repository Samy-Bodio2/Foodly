set serveroutput on;
CREATE OR REPLACE FUNCTION custFonc(varNom VARCHAR)
RETURN INT IS
    valt Users.id_user%TYPE;
    valt2 Customers%ROWTYPE;

    CURSOR iduser IS
    SELECT id_user from Users where username = varNom;

    CURSOR custs IS
    SELECT * from Customers;
BEGIN
    OPEN iduser;
    OPEN custs;
    FETCH iduser INTO valt;

    LOOP
        FETCH custs INTO valt2;
        EXIT WHEN valt2.id_user = valt;
            
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Nom du Menu:'||valt2.id_user);

    RETURN valt2.id_user;
END;
/
DECLARE
PROCEDURE operation
AS
    varnomFonc int := custFonc('&Enter_Your_Username');

    CURSOR QUAN IS
    SELECT Quantity from Control_Panier_Menu cpm
    JOIN Panier P
    ON P.id_panier = cpm.id_panier
    JOIN Customers C
    ON C.id_cust = P.id_cust
    WHERE C.id_cust = varnomFonc;
    CURSOR MenuID IS
    SELECT M.id_menu from Menu M
    JOIN Control_Panier_Menu CPM
    ON CPM.id_menu = M.id_menu
    JOIN Panier P
    ON P.id_panier = CPM.id_panier
    JOIN Customers C
    ON C.id_cust = P.id_cust
    WHERE C.id_cust = varnomFonc;

    valt Control_Panier_Menu.Quantity%TYPE;
    valt2 Menu.id_menu%TYPE;
BEGIN
    OPEN QUAN;
    OPEN MenuID;
    FETCH QUAN INTO valt;
    FETCH MenuID INTO valt2;
    UPDATE MENU 
    SET Menu_Qty = Menu_Qty + valt
    WHERE id_menu = valt2;
    DELETE FROM Panier
    WHERE id_cust = varnomFonc;
END;
BEGIN
operation;
END;
/
set serveroutput on;
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
    DBMS_OUTPUT.PUT_LINE('Reussite de la Suppression'||valt2.id_cust);
    RETURN valt2.id_cust;
    ELSE
    DBMS_OUTPUT.PUT_LINE('Echec de la Suppression');
    RETURN 0;
    END if;
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
    DELETE FROM Customers
    WHERE id_cust = varnomFonc;
END;
BEGIN
operation;
END;
/
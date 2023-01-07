DECLARE
PROCEDURE operation
AS
    varnomFonc int := custFonc('&Enter_Your_Username');

    CURSOR QUAN IS
    SELECT Quantity from Choix cpm
    JOIN Panier P
    ON P.id_panier = cpm.id_panier
    JOIN Customers C
    ON C.id_cust = P.id_cust
    WHERE C.id_cust = varnomFonc;
    CURSOR MenuID IS
    SELECT M.id_menu from Menu M
    JOIN Choix CPM
    ON CPM.id_menu = M.id_menu
    JOIN Panier P
    ON P.id_panier = CPM.id_panier
    JOIN Customers C
    ON C.id_cust = P.id_cust
    WHERE C.id_cust = varnomFonc;

    valt Choix.Quantity%TYPE;
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

@Features/Features_customer/Menu_customer
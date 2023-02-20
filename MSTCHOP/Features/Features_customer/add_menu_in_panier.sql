SELECT * FROM Menu;

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
@Features/Features_customer/commander




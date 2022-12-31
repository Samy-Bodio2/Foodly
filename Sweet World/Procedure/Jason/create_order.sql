DECLARE
    v_Panier Panier.id_Panier%type;
    v_customer_id Panier.id_cust%type;
    v_Menu_Qty Menu.Menu_Qty%type;
    v_menu_id Menu.id_menu%type;
    v_id_resto Restaurant.id_resto%type;
    choice_qte Choix.Quantity%type;
        
    PROCEDURE CREATE_ORDERS AS

    BEGIN 

        SELECT id_Panier INTO v_Panier
        FROM Panier
        WHERE id_cust=v_customer_id;

        SELECT id_cust INTO v_customer_id
        FROM Customers c
        JOIN Users u
        ON (c.id_user=u.id_user)
        WHERE u.username='&username' AND u.password='&password';

        IF sql%found THEN

        SELECT id_resto INTO v_id_resto
        FROM Restaurant
        WHERE name_resto = '&name_resto';

        SELECT Menu_Qty INTO v_Menu_Qty
        FROM Menu
        WHERE id_menu=v_menu_id;

        SELECT Quantity INTO choice_qte
        FROM choix
        WHERE id_menu = v_menu_id;

        INSERT INTO Orders
        (
                id_order,order_date,id_resto,id_Panier 
        )
        VALUES
        (
                id_order_seq.nextval, to_char(sysdate,'dd/mm/yyyy'),v_id_resto,v_Panier
        );

        v_Menu_Qty := v_Menu_Qty-choice_qte;

        UPDATE Menu 
        set Menu_Qty = v_Menu_Qty; 

        DELETE FROM Choix
        WHERE id_Panier=v_Panier;

        ELSE 
        DBMS_OUTPUT.PUT_LINE('votre login et mot de passe sont faux... entrez les a nouveau : ');
        END IF;

        exception
        WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('aucune valeur trouvée');

    END ;
BEGIN
    CREATE_ORDERS;
END;
/
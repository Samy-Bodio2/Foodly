Prompt
Prompt**************************************************************************
Prompt***************************** MENU PRINCIPAL *****************************
Prompt**************************************************************************
Prompt

BEGIN
    DBMS_OUTPUT.PUT_LINE('Bienvenue dans Sweet World!');
    DBMS_OUTPUT.PUT_LINE('Veuillez choisir une option');
    DBMS_OUTPUT.PUT_LINE('1. Gestion des restaurants');
    DBMS_OUTPUT.PUT_LINE('2. Gestion des clients');
    DBMS_OUTPUT.PUT_LINE('3. Gestion des menus');
    DBMS_OUTPUT.PUT_LINE('4. Gestion des commandes');
    DBMS_OUTPUT.PUT_LINE('5. Gestion des livraisons');
    DBMS_OUTPUT.PUT_LINE('6. Gestion des factures');
    DBMS_OUTPUT.PUT_LINE('7. Gestion des paiements');
    DBMS_OUTPUT.PUT_LINE('8. Quitter');
  CASE &number_selected
    WHEN 1 THEN
    @Features\Feature_restaurant\restaurant_menu.sql
    WHEN 2 THEN
    @Features\Feature_customers\customer_menu.sql
    WHEN 3 THEN
    @Features\Feature_menu\menu_menu.sql
    WHEN 4 THEN
    @Features\Feature_order\order_menu.sql    
    WHEN 5 THEN
    @Features\Feature_delivery\delivery_menu.sql
    WHEN 6 THEN
    @Features\Feature_bill\bill_menu.sql
    WHEN 7 THEN
    @Features\Feature_payment\payment_menu.sql
    WHEN 8 THEN
    DBMS_OUTPUT.PUT_LINE('Au revoir !');
    EXIT;
    ELSE
        DBMS_OUTPUT.PUT_LINE('Vous avez choisi une option invalide !');
  END CASE;
END;
/
BEGIN
DBMS_OUTPUT.PUT_LINE('****************Bienvenue sur Sweet World!****************');
DBMS_OUTPUT.PUT_LINE('Bonjour, que souhaitez vous faire aujourdhui ?');
DBMS_OUTPUT.PUT_LINE('1. Consulter le menu du jour');
DBMS_OUTPUT.PUT_LINE('2. Consulter le details dun menu');
DBMS_OUTPUT.PUT_LINE('3. Consulter les restaurants');
DBMS_OUTPUT.PUT_LINE('4. Rechercher un menu');
DBMS_OUTPUT.PUT_LINE('5. Ajouter un menu au panier');
DBMS_OUTPUT.PUT_LINE('6. Effectuer une commande');
DBMS_OUTPUT.PUT_LINE('7. Consulter ses commandes');
DBMS_OUTPUT.PUT_LINE('8. Noter un restaurant');
DBMS_OUTPUT.PUT_LINE('9. Se deconnecter');
DBMS_OUTPUT.PUT_LINE('10. Quitter')
CASE &number_selected
WHEN 1 THEN
@Features/Menu/consult_menu.sql
WHEN 2 THEN
@Features/Menu/consult_menu_details.sql
WHEN 3 THEN
@Sweet World/Features/Feature_customers/consult_restaurant.sql
WHEN 4 THEN
@Features/Menu/search_menu.sql
WHEN 5 THEN
@Sweet World/Features/Feature_customers/add_menu_in_panier.sql
WHEN 6 THEN
@Sweet World/Features/Feature_customers/create_orders.sql
WHEN 7 THEN
@Sweet World/Features/Feature_customers/consult_orders.sql
WHEN 8 THEN
@Sweet World/Features/Feature_customers/note_restaurant.sql
WHEN 9 THEN
DBMS_OUTPUT.PUT_LINE('Voulez vous vous deconnecter (y/n) ?');
IF &quit = 'y' THEN
@Features/Menu/login_client.sql
END IF;
WHEN 10 THEN
DBMS_OUTPUT.PUT_LINE('Voulez vous vous revenir au menu principal (y/n) ?');
IF &retour = 'y' THEN
@Features/Menu/main_menu.sql
ELSIF &retour = 'n' THEN 
DBMS_OUTPUT.PUT_LINE('Voulez vous vraiment nous quitter(y/n) ?');
IF &quit = 'y' THEN 
DBMS_OUTPUT.PUT_LINE('Au revoir !');
EXIT;
END IF;
END IF;
ELSE
DBMS_OUTPUT.PUT_LINE('Vous avez choisi une option invalide !');
END CASE;
END;
/


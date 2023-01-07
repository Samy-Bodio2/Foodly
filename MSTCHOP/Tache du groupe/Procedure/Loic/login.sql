BEGIN
DBMS_OUTPUT.PUT_LINE('Bienvenue sur le menu de connexion');
DBMS_OUTPUT.PUT_LINE('Quel est votre statut actuel ?');
DBMS_OUTPUT.PUT_LINE('1. Client');
DBMS_OUTPUT.PUT_LINE('2. Restaurant');
DBMS_OUTPUT.PUT_LINE('3. Admin');
CASE &number_selected
WHEN 1 THEN
@Features/Menu/login_client.sql
WHEN 2 THEN
@Features/Menu/login_restaurant.sql
WHEN 3 THEN
@Features/Menu/login_admin.sql
ELSE
DBMS_OUTPUT.PUT_LINE('Vous avez choisi une option invalide !');
END CASE; 
END;
/
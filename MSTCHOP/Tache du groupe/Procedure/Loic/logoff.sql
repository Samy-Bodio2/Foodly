BEGIN 
DBMS_OUTPUT.PUT_LINE('Bienvenue sur le menu de connexion');
DBMS_OUTPUT.PUT_LINE('Veuillez entrer votre identifiant et mot de passe');
SELECT * FROM Users WHERE username = &id_client AND password = &password;
IF SQL%NOTFOUND THEN
DBMS_OUTPUT.PUT_LINE('Identifiant ou mot de passe invalide !');
ELSE
DBMS_OUTPUT.PUT_LINE('Retour au menu de connexion !');
@Features/Menu/main_menu.sql
END IF;
END;
/
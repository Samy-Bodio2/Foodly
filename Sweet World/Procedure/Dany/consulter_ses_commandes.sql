
--'''''''''''''''''''''''''''''''''''''''''''''''''''''' crating by kenchoung''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''

/*CREATE PROCEDURE consult_ses_commande IS 
V_nom_cmplet         Menu.Menu_title%TYPE;
V_Nom_Client    customers.first_namee%TYPE;
V_menu_prix         Menu.Menu_price%TYPE;
v_Menu_date          Menu.Menu_date%TYPE;
v_Menu_Qty           Menu.Menu_Qty%TYPE;
V_name_dish          dish.Name_dish%TYPE;
V_name_seculant      Seculant.Name_Seculant%TYPE;
V_palt_complement    complement.Name_complement%TYPE;
V_name_Resro         restaurant.name_resto%TYPE;
V_name_client               ADMIN.name_admin%TYPE;
BEGIN 
DBMS_OUTPUT.PUT_LINE('Vueiller entrer votre nom et votre mot de passe: ');*/
SELECT 
Menu_title,
first_name||last_name,
Menu_price,
Menu_date,
Menu_Qty,
Name_dish,
Name_Seculant,
Name_complement,
order_date,
name_resto
/*
INTO 
V_Menu_title  ,       
V_Nom_Client ,   
V_menu_price ,   
v_Menu_date ,        
v_Menu_Qty  ,        
V_name_dish   ,       
V_name_seculant ,    
V_palt_complement ,  
V_name_Resro */
FROM Orders o
JOIN panier p
ON p.id_panier = o.id_panier
JOIN customers c 
ON c.id_cust = p.id_cust
JOIN users u
ON u.id_user = c.id_user
JOIN restaurant r 
ON u.id_user = r.id_user
JOIN Menu m
ON r.id_resto = m.id_resto
JOIN dish d 
ON d.id_dish = m.id_dish 
JOIN SECULANT s 
ON s.id_seculant = m.id_seculant 
JOIN complement c 
ON c.id_complement = m.id_complement
WHERE username = '&username' AND password = '&password';
/*
END;

/
BEGIN
consult_ses_commande;
END;
/*/

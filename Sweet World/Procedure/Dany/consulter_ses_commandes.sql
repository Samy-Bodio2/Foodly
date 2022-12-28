
--'''''''''''''''''''''''''''''''''''''''''''''''''''''' crating by kenchoung''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''

CREATE PROCEDURE consult_Detaille_Menu IS 
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
V_pswd_clien               ADMIN.pwd_admin%TYPE;
BEGIN 
DBMS_OUTPUT.PUT_LINE('Vueiller entrer votre nom et votre mot de passe: ');
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
INTO 
V_Menu_title  ,       
V_Nom_Client ,   
V_menu_price ,   
v_Menu_date ,        
v_Menu_Qty  ,        
V_name_dish   ,       
V_name_seculant ,    
V_palt_complement ,  
V_name_Resro 
FROM Menu
JOIN Dish
ON dish.id_dish = Menu.id_dish
JOIN Seculant 
ON Seculant.id_seculant = Menu.id_seculant
JOIN complement 
ON complement.id_complement = menu.id_complement
JOIN restaurant
ON restaurant.id_resto = Menu.id_resto
JOIN Orders
ON restaurant.id_resto = Orders.id_resto
JOIN Panier
ON  Panier.id_panier = Orders.id_panier
JOIN customers
ON customers.id_cust = panier.id_cust
WHERE username = '&username' AND password = '&password';    
END;
/
BEGIN
consult_Detail_Menu;
END;
/

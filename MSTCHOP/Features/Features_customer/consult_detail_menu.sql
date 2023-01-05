CREATE OR REPLACE PROCEDURE consult_detailler_Menu IS 
V_Menu_title         Menu.Menu_title%TYPE;
V_Descrition_Menu    Menu.Menu_description%TYPE;
V_menu_price         Menu.Menu_price%TYPE;
v_Menu_date          Menu.Menu_date%TYPE;
v_Menu_Qty           Menu.Menu_Qty%TYPE;
V_name_dish          dish.Name_dish%TYPE;
V_name_seculant      Seculant.Name_Seculant%TYPE;
V_palt_garnish       garnish.Name_Garnish%TYPE;
V_name_Resro         restaurant.name_resto%TYPE;
V_Menu_title2         Menu.Menu_title%TYPE;
BEGIN 
DBMS_OUTPUT.PUT_LINE('veiller entrer le titre du menu donc vous souhetez consulter le detaille :');
SELECT 
Menu_title,
Menu_description,
Menu_price,
Menu_date,
Menu_Qty,
Name_dish,
Name_Seculant,
Name_garnish,
name_resto
INTO 
V_Menu_title  ,       
V_Descrition_Menu ,   
V_menu_price   ,   
v_Menu_date ,        
v_Menu_Qty  ,        
V_name_dish   ,       
V_name_seculant ,    
V_palt_garnish ,  
V_name_Resro 
FROM Menu M
JOIN Dish
ON dish.id_dish = M.id_dish
JOIN Seculant S
ON S.id_seculant = M.id_seculant
JOIN Garnish C
ON C.id_garnish = M.id_garnish
JOIN restaurant R
ON R.id_resto = M.id_resto
WHERE M.Menu_title = '&Menu_title';
 DBMS_OUTPUT.PUT_LINE('Nom du Menu:'||V_Menu_title||'  '||'Description du Menue:'||V_Descrition_Menu||'  '||'Prix du Menu:'||V_menu_price ||'  '||'date du menu:'||v_Menu_date||' '||'Quantite du Menu:'||v_Menu_Qty ||' '||'Nom du plat :'||V_name_dish||' '||'Nom seculent:'||V_name_seculant||' '||'Nom garnish:'||V_palt_garnish||' '||'nom du restaurant:'||V_name_Resro);
END;
/
BEGIN
consult_detailler_Menu;
END;
/


@Features/Features_customer/Menu_customer
Select Menu_title,
       Menu_description,
       Menu_price,
       Menu_date,
       Menu_Qty,
       D.Name_dish,
       S.Name_Seculant,
      C.Name_complement
From Menu M
   join Dish D
   on M.id_dish = D.id_dish
   join Complement C
   on C.id_complement = M.id_complement
   join Seculant S
   on S.id_seculant = M.id_seculant
   join Restaurant R
   on R.id_resto = M.id_resto
WHERE M.Menu_title = '&Menu_title';


















/*
CREATE OR REPLACE PROCEDURE consult_details_menu  IS 
m_Menu_title         Menu.Menu_title%TYPE;
m_Descrition_Menu    Menu.Menu_description%TYPE;
m_menu_price         Menu.Menu_price%TYPE;
m_Menu_date          Menu.Menu_date%TYPE;
m_Menu_Qty           Menu.Menu_Qty%TYPE;
m_name_dish          dish.Name_dish%TYPE;
m_name_seculant      Seculant.Name_Seculant%TYPE;
m_palt_complement    complement.Name_complement%TYPE;
m_name_Resro         restaurant.name_resto%TYPE;
m_Menu_title2         Menu.Menu_title%TYPE;
BEGIN 
SELECT Menu_title
INTO m_Menu_title2 
FROM Menu;
DBMS_OUTPUT.PUT_LINE('Saisir le titre du menu dont vous voulez consulter le detaille :');
SELECT 
Menu_title,
Menu_description,
Menu_price,
Menu_date,
Menu_Qty,
Name_dish,
Name_Seculant,
Name_complement,
name_resto
INTO 
m_Menu_title  ,       
m_Descrition_Menu ,   
m_menu_price   ,   
m_Menu_date ,        
m_Menu_Qty  ,        
m_name_dish   ,       
m_name_seculant ,    
m_palt_complement ,  
m_name_Resro 
FROM Menu M
JOIN Dish
ON dish.id_dish = M.id_dish
JOIN Seculant S
ON S.id_seculant = M.id_seculant
JOIN complement C
ON C.id_complement = M.id_complement
JOIN restaurant R
ON R.id_resto = M.id_resto
WHERE M.Menu_title = '&Menu_title';
 DBMS_OUTPUT.PUT_LINE('Nom du Menu:'||m_Menu_title||'  '||'Description du Menue:'||m_Descrition_Menu||'  '||'Prix du Menu:'||m_menu_price ||'  '||'date du menu:'||m_Menu_date||' '||'Quantite du Menu:'||m_Menu_Qty ||' '||'Nom du plat :'||m_name_dish||' '||'Nom seculent:'||m_name_seculant||' '||'Nom complement:'||m_palt_complement||' '||'nom du restaurant:'||m_name_Resro);
END;
/
BEGIN
consult_details_menu;
END;
/

*/





















































































































































































































































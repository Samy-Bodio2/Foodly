SELECT Menu_title,
       Menu_description,
       Menu_price,
       Menu_date,
       Menu_Qty,
       d.Name_dish,
       s.Name_Seculant,
       g.Name_garnish
FROM Menu m
   JOIN Dish d
   ON m.id_dish = d.id_dish
   JOIN Garnish g
   ON g.id_garnish= m.id_garnish
   JOIN Seculant s
   ON s.id_seculant = m.id_seculant
   JOIN Restaurant r
   ON r.id_resto = m.id_resto
WHERE m.Menu_title = '&Menu_title';


















/*
CREATE OR REPLACE PROCEDURE cONsult_details_menu  IS 
m_Menu_title         Menu.Menu_title%TYPE;
m_DescritiON_Menu    Menu.Menu_descriptiON%TYPE;
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
DBMS_OUTPUT.PUT_LINE('Saisir le titre du menu dONt vous voulez cONsulter le detaille :');
SELECT 
Menu_title,
Menu_descriptiON,
Menu_price,
Menu_date,
Menu_Qty,
Name_dish,
Name_Seculant,
Name_complement,
name_resto
INTO 
m_Menu_title  ,       
m_DescritiON_Menu ,   
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
 DBMS_OUTPUT.PUT_LINE('Nom du Menu:'||m_Menu_title||'  '||'DescriptiON du Menue:'||m_DescritiON_Menu||'  '||'Prix du Menu:'||m_menu_price ||'  '||'date du menu:'||m_Menu_date||' '||'Quantite du Menu:'||m_Menu_Qty ||' '||'Nom du plat :'||m_name_dish||' '||'Nom seculent:'||m_name_seculant||' '||'Nom complement:'||m_palt_complement||' '||'nom du restaurant:'||m_name_Resro);
END;
/
BEGIN
cONsult_details_menu;
END;
/

*/





















































































































































































































































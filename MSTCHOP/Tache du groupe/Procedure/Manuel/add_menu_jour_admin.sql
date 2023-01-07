set serveroutput on;
CREATE OR REPLACE FUNCTION id_dish(nom VARCHAR)
RETURN INT IS
CURSOR iddish IS
SELECT id_dish from Dish where Name_dish = nom;
valeur INT;
BEGIN
OPEN iddish;
FETCH iddish into valeur;
RETURN valeur;
END;
/

CREATE OR REPLACE FUNCTION id_seculant(nom VARCHAR)
RETURN INT IS
CURSOR idsecu IS
SELECT id_seculant from Seculant where Name_Seculant = nom;
valeur INT;
BEGIN
OPEN idsecu;
FETCH idsecu into valeur;
RETURN valeur;
END;
/

CREATE OR REPLACE FUNCTION id_complement(nom VARCHAR)
RETURN INT IS
CURSOR idcomple IS
SELECT id_complement from Complement where Name_complement = nom;
valeur INT;
BEGIN
OPEN idcomple;
FETCH idcomple into valeur;
RETURN valeur;
END;
/

CREATE OR REPLACE FUNCTION id_restau(nom VARCHAR)
RETURN INT IS
CURSOR idresto IS
SELECT id_resto from Restaurant where Name_resto = nom;
valeur INT;
BEGIN
OPEN idresto;
FETCH idresto into valeur;
RETURN valeur;
END;
/

INSERT INTO Menu(id_menu, Menu_title,Menu_description,Menu_price, Menu_date,Menu_Qty,id_dish,id_seculant,id_complement,id_resto,id_config)VALUES
(id_menu_seq.nextval, '&Menu_Title','&Menu_Description',&Price_of_Menu,
SYSDATE,&Quantity_Menu,id_dish('&dish_name'),id_seculant('&seculant_name'),id_complement('&Name_garnish'),id_restau('&Name_of_the_restaurant'),1);
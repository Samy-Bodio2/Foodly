set serveroutput on;
DECLARE
result varchar(50);
repas Dish%ROWTYPE;
BEGIN
result := lower('&Plat');
IF result like '%burger%' or result like '%sandwich%' or result like '%steak%'
or result like '%pain%' or result like '%boeuf%' or result like '%viande%'
or result like '%poulet%' or result like '%hambourg%' or result like '%hotdog%'
or result like '%kebab%' or result like '%fromage%' or result like '%fast food%'
or result like '%nourritue%' or result like '%snack%' or result like '%macdo%' THEN
select * into repas from Dish where Name_dish = 'Hamburger';
DBMS_OUTPUT.PUT_LINE(repas.id_dish||' '||repas.Name_dish);
ELSIF result like '%dolait%' or result like '%ndole%' or result like '%dole%'
or result like '%ndolait%' or result like '%dolet%' or result like '%dhole%'
or result like '%nndole%' or result like '%elodn%' or result like '%mbole%'
or result like '%ntole%' THEN
select * into repas from Dish where Name_dish = 'Ndole';
DBMS_OUTPUT.PUT_LINE(repas.id_dish||' '||repas.Name_dish);
ELSIF result like 
'%eru%'
or result like '%heros%' or result like '%hero%'
or result like '%heru%'
or result like '%ero%' THEN
select * into repas from Dish where Name_dish = 'Eru';
DBMS_OUTPUT.PUT_LINE(repas.id_dish||' '||repas.Name_dish);
ELSIF result like 'taro' or result like '%taru%' or result like '%ntaro%' or result like '%taroo%'
or result like '%ntaroo%' or result like '%tarou%' or result like '%tharo%' or result like '%taaro%'
or result like '%tsaro%' or result like '%tsaroo%'THEN
select * into repas from Dish where Name_dish = 'Taro';
DBMS_OUTPUT.PUT_LINE(repas.id_dish||' '||repas.Name_dish);
ELSIF result like '%okok%' or result like '%lokok%' or result like '%leko%' or result like '%lekok%'
or result like '%lecoq%' or result like '%locoq%' or result like '%lecok%' or result like '%lecoc%'
or result like '%lococ%' or result like '%ecoc%' or result like '%ococ%' or result like '%le coq%'
or result like '%le kok%' or result like '%lo kok%' or result like '%leokok%' or result like '%eqoc%'
or result like '%oqoc%' or result like '%leqoq%' or result like '%leqoc%' or result like '%loqoc%'
or result like '%e kok%' or result like '%o kok%' or result like '%kok%' or result like '%coq%'
or result like '%ikok%' or result like '%likok%' or result like '%licoc%' or result like '%likoq%'
or result like '%le qoc%' or result like '%le koq%' or result like '%le qok%'THEN
select * into repas from Dish where Name_dish = 'Okok';
DBMS_OUTPUT.PUT_LINE(repas.id_dish||' '||repas.Name_dish);
ELSIF result like '%pilé%' or result like '%pillé%' or result like '%pile%' or result like '%pille%'
or result like '%mpile%' or result like '%mpille%' or result like '%mpilé%' or result like '%mpillé%'
or result like '%pillée%' or result like '%piler%' or result like '%piller%' or result like '%mpiller%' THEN
select * into repas from Dish where Name_dish = 'Pilé';
DBMS_OUTPUT.PUT_LINE(repas.id_dish||' '||repas.Name_dish);
ELSE
DBMS_OUTPUT.PUT_LINE('repas non trouve');
END IF;
END;
/
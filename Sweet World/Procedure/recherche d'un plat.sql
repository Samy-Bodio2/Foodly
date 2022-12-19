set serveroutput on;
DECLARE
result23 varchar(50);
result varchar(50);
plat Dish%ROWTYPE;
PROCEDURE select_dish(pl IN VARCHAR) AS
BEGIN
select * into plat from Dish where Name_dish = pl;
DBMS_OUTPUT.PUT_LINE(plat.id_dish ||'   '||plat.Name_dish);
END;
BEGIN
result := lower('&Plat');
IF result like '%burger%' or result like '%sandwich%' or result like '%steak%' or result like '%hamburger%'
or result like '%pain%' or result like '%boeuf%' or result like '%viande%'
or result like '%poulet%' or result like '%hambourg%' or result like '%hotdog%'
or result like '%kebab%' or result like '%fromage%' or result like '%fast food%'
or result like '%nourritue%' or result like '%snack%' or result like '%macdo%' THEN
result23 := 'Hamburger';
select_dish(result23);
ELSIF result like '%dolait%' or result like '%ndole%' or result like '%dole%'
or result like '%ndolait%' or result like '%dolet%' or result like '%dhole%'
or result like '%nndole%' or result like '%elodn%' or result like '%mbole%'
or result like '%ntole%' THEN
result23 := 'Ndole';
select_dish(result23);
ELSIF result like 
'%eru%' or result like '%erru%' or result like '%herru%' or result like '%herro%' 
or result like '%heros%' or result like '%hero%' or result like '%herros%'
or result like '%heru%' or result like '%herrus%' or result like '%eros%' or result like '%erus%'
or result like '%ero%' THEN
result23 := 'Eru';
select_dish(result23);
ELSIF result like 'taro' or result like '%taru%' or result like '%ntaro%' or result like '%taroo%'
or result like '%ntaroo%' or result like '%tarou%' or result like '%tharo%' or result like '%taaro%'
or result like '%tsaro%' or result like '%tsaroo%' THEN
result23 := 'Taro';
select_dish(result23);
ELSIF result like '%okok%' or result like '%lokok%' or result like '%leko%' or result like '%lekok%'
or result like '%lecoq%' or result like '%locoq%' or result like '%lecok%' or result like '%lecoc%'
or result like '%lococ%' or result like '%ecoc%' or result like '%ococ%' or result like '%le coq%'
or result like '%le kok%' or result like '%lo kok%' or result like '%leokok%' or result like '%eqoc%'
or result like '%oqoc%' or result like '%leqoq%' or result like '%leqoc%' or result like '%loqoc%'
or result like '%e kok%' or result like '%o kok%' or result like '%kok%' or result like '%coq%'
or result like '%ikok%' or result like '%likok%' or result like '%licoc%' or result like '%likoq%'
or result like '%le qoc%' or result like '%le koq%' or result like '%le qok%' THEN
result23 := 'Okok';
select_dish(result23);
ELSIF result like '%pilé%' or result like '%pillé%' or result like '%pile%' or result like '%pille%'
or result like '%mpile%' or result like '%mpille%' or result like '%mpilé%' or result like '%mpillé%'
or result like '%pillée%' or result like '%piler%' or result like '%piller%' or result like '%mpiller%' THEN
result23 := 'Pilé';
select_dish(result23);
ELSIF result like '%mbongo%' or result like '%bongo%' or result like '%ngombo%' or result like '%bogo%'
or result like '%mbogo%' THEN
result23 := 'Mbongo';
select_dish(result23);
ELSIF result like '%sanga%' or result like '%nsanga%' or result like '%saga%' or result like '%senga%'
or result like '%cenga%' or result like '%canga%' or result like '%zanga%' or result like '%le sanga%'
or result like '%tsanga%' THEN
result23 := 'Sanga';
select_dish(result23);
ELSIF result like 'nkui' or result like '%kui%' or result like '%qi%' or result like '%cuit%'
or result like '%ncui%' or result like '%nkuit%' or result like '%kuit%' or result like '%nkiu%'
or result like '%ciu%' or result like '%nqi%' or result like '%qui%' or result like '%nqui%'
or result like '%quit%' or result like '%nquit%' or result like '%qui%' THEN
result23 := 'Nkui';
select_dish(result23);
ELSIF result like '%nkontchap%' or result like '%conchap%' or result like '%konchap%' or result like '%conchape%'
or result like '%kontchap%' or result like '%nconchap%' or result like '%cuontchap%' or result like '%nkuontchap%'
or result like '%qontchap%' or result like '%tchap%' or result like '%quontchap%' or result like '%qonchap%'
or result like '%chap%' THEN
result23 := 'Nkontchap';
select_dish(result23);
ELSIF result like '%koki%' or result like '%coci%' or result like '%coqi%' or result like '%coqui%'
or result like '%koci%' or result like '%quoki%' or result like '%nkoki%' or result like '%ncoki%'
or result like '%coki%' or result like '%nqoki%' or result like '%nquoki%' THEN
result23 := 'Koki';
select_dish(result23);
ELSIF result like '%bekwam%' or result like '%bekwan%' or result like '%bequan%' or result like '%bekuan%'
or result like '%becuan%' or result like '%bekuan%' or result like '%bekwuan%' or result like '%%'
 or result like '%bequam%' or result like '%bekuam%'
or result like '%becuam%' or result like '%bekuam%' or result like '%bekwuam%' THEN
result23 := 'Bekwam';
select_dish(result23);
ELSIF result like '%mitumba%' or result like '%mitoumba%' or result like '%mintounba%'
or result like '%mitouba%' or result like '%mintumba%' or result like '%mituba%' 
or result like '%mintoumba%' or result like '%mintuba%' or result like '%mintunba%' THEN
result23 := 'Mitumba';
select_dish(result23);
ELSIF result like '%banane malaxe%' or result like '%banane%' or result like '%malaxe%'
or result like '%malaxé%' THEN
result23 := 'Banane malaxé';
select_dish(result23);
ELSE
DBMS_OUTPUT.PUT_LINE('repas non trouve');
END IF;
END;
/
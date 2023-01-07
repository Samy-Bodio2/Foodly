set serveroutput on;

--fonction pour récupérer l'id du plat
create or replace function id_dish(nom varchar)
return int is 
cursor idDish is 
select id_dish from dish where name_dish = nom;
id int;
begin 
open idDish;
fetch idDish into id;
return id;
end;
/

--fonction pour récupérer l'id du seculant
create or replace function id_seculant(nom varchar)
return int is 
cursor idSeculant is 
select id_seculant from seculant where name_seculant = nom;
id int;
begin 
open idSeculant;
fetch idSeculant into id;
return id;
end;
/

-- fonction pour récupérer l'id du complément
-- function id_garnish(gar varchar)
-- return int is 
-- cursor idGarnish is 
-- select id_garnish from garnish where name_garnish = gar;
-- id_G int;
-- begin 
-- open idGarnish;
-- fetch idGarnish into id_G;
-- return id;
-- end; 
-- /

-- fonction qui va récupérer l'id du user qui a le restaurant
create or replace function id_user(nom1 varchar, nom2 varchar)
return int is 
cursor idUser is 
select id_user from users 
where username = nom1 and password = nom2;
id int;
begin 
open idUser;
fetch idUser into id;
return id;
end;
/

-- fonction qui va récupérer l'id du restaurant
-- function id_resto(nom1 varchar,nom2 varchar)
-- return int is 
-- declare
-- cursor idResto is 
-- select id_resto from restaurant where id_user = id_user(nom1,nom2);
-- id int;
-- begin 
-- open idResto;
-- fetch idResto into id;
-- return id;
-- end;
-- /

declare

  cursor idResto is 
  select id_resto from restaurant where id_user = id_user('&username','&password');
  id_R int;

  cursor idGarnish is 
  select id_garnish from garnish where name_garnish ='&complement';
  id_G int;

  id_D int := id_dish('&plat');
  id_S int := id_seculant('&seculant');

begin

  open idResto;
  fetch idResto into id_R;

  open idGarnish;
  fetch idGarnish into id_G;

  insert into menu(id_menu,Menu_title,Menu_description,Menu_price,Menu_date,Menu_Qty,
  id_dish,id_seculant,id_garnish,id_resto,id_config)
  values (id_menu_seq.nextval,'&titre','&description',&prix,to_date(sysdate,'dd-mm-yyy'),&quantite,
  id_D,id_S,id_G,id_R,2);
  DBMS_OUTPUT.PUT_LINE(' ');
  DBMS_OUTPUT.PUT_LINE ('menu ajoute!');

end;
/
set serveroutput on;

 -- fonction pour récupérer l'id du user du client conserné
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

-- function pour récupérer l'id du client
create or replace function id_cust(nom1 varchar, nom2 varchar)
return int is 
cursor idCust is 
select id_cust from customers where id_user = id_user(nom1, nom2);
id int;
begin 
open idCust;
fetch idCust into id;
return id;
end;
/

-- fonction pour récupérer l'id du panier du client
create or replace function id_panier(nom1 varchar, nom2 varchar)
return int is 
cursor idPanier is 
select id_panier from panier where id_cust = id_cust(nom1, nom2);
id int;
begin 
open idPanier;
fetch idPanier into id;
return id;
end;
/

-- foction pour récupérer l'id du restaurant
create or replace function id_resto(nom varchar)
return int IS
cursor idResto is 
select id_resto from restaurant where name_resto = nom;
id int;
begin 
open idResto;
fetch idResto into id;
return id;
end;
/

declare


v_id_panier int :=id_panier('&username','&password');

cursor idMenu is 
select id_menu from menu where menu_title = '&menu' and id_resto = id_resto('&restaurant');
idM int;

begin
open idMenu;
fetch idMenu into idM;

insert into choix(id_panier,id_menu,Quantity)
values (v_id_panier, idM, &quantite);

end;
/
set serveroutput on;

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

declare 
v_id_resto int :=id_resto('&restaurant');
v_id_panier int :=id_panier('&username','&password');
begin 

insert into orders (id_order,order_date,id_resto,id_panier)
values (id_order_seq.nextval, to_date(sysdate,'dd-mm-yyyy'), v_id_resto, v_id_panier);
DBMS_OUTPUT.PUT_LINE ('commande effectuée!');

delete from choix where id_panier = v_id_panier;

end;
/

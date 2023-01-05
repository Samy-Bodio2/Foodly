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
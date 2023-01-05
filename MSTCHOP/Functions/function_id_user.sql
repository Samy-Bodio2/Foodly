CREATE OR REPLACE FUNCTION idutil(nom VARCHAR)
RETURN INT IS
CURSOR iduse IS
SELECT id_user from Users where username = nom;
entier INT;
BEGIN
OPEN iduse;
FETCH iduse into entier;
RETURN entier;
END;
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
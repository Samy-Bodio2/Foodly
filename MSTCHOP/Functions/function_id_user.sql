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
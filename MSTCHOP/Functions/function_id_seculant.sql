CREATE OR REPLACE FUNCTION id_seculant(nom VARCHAR)
RETURN INT IS
CURSOR idsecu IS
SELECT id_seculant from Seculant where Name_Seculant = nom;
entier INT;
BEGIN
OPEN idsecu;
FETCH idsecu into entier;
RETURN entier;
END;
/
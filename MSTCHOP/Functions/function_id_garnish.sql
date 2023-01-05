CREATE OR REPLACE FUNCTION id_garnish(nom VARCHAR)
RETURN INT IS
CURSOR idcomple IS
SELECT id_garnish from Garnish where Name_garnish = nom;
entier INT;
BEGIN
OPEN idcomple;
FETCH idcomple into entier;
RETURN entier;
END;
/
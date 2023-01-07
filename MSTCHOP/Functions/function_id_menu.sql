CREATE OR REPLACE FUNCTION id_menu(nom VARCHAR)
RETURN INT IS
CURSOR idmen IS
SELECT id_menu from Menu where Menu_title = nom;
entier INT;
BEGIN
OPEN idmen;
FETCH idmen into entier;
RETURN entier;
END;
/
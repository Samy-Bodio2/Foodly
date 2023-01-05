CREATE OR REPLACE FUNCTION id_dish(nom VARCHAR)
RETURN INT IS
CURSOR iddish IS
SELECT id_dish from Dish where Name_dish = nom;
entier INT;
BEGIN
OPEN iddish;
FETCH iddish into entier;
RETURN entier;
END;
/
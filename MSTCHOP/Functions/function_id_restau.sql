CREATE OR REPLACE FUNCTION id_restau(nom VARCHAR)
RETURN INT IS
CURSOR idresto IS
SELECT id_resto from Restaurant where Name_resto = nom;
entier INT;
BEGIN
OPEN idresto;
FETCH idresto into entier;
RETURN entier;
END;
/
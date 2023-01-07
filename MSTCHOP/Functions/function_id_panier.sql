
    CREATE OR REPLACE FUNCTION idpan(nom VARCHAR)
    RETURN INT IS
    CURSOR idpanier IS
    SELECT P.id_panier from Panier P
    join Customers C
    on P.id_cust = C.id_cust 
    join Users S
    on S.id_user = C.id_user
    where S.username = nom;
    entier INT;
    BEGIN
    OPEN idpanier;
    FETCH idpanier into entier;
    RETURN entier;
    END;
    /


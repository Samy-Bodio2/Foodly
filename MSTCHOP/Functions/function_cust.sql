CREATE OR REPLACE FUNCTION custFonc(varNom VARCHAR)
RETURN INT IS
    valt Users.id_user%TYPE;
    valt2 Customers%ROWTYPE;
    valt3 Users.username%TYPE;

    entier int := id_customers_seq.currval;
    CURSOR iduser IS
    SELECT id_user from Users where username = varNom;

    CURSOR idusername IS
    SELECT U.username from Users U
    JOIN Customers C
    ON C.id_user = U.id_user
    where C.id_user = (
        SELECT id_user from Users where username = varNom
    );

    CURSOR custs IS
    SELECT * from Customers;
BEGIN
    OPEN idusername;
    FETCH idusername INTO valt3;
    IF valt3 = varNom THEN
    OPEN iduser;
    OPEN custs;
    FETCH iduser INTO valt;

    FOR i IN 1..entier LOOP
            FETCH custs INTO valt2;
            EXIT WHEN valt2.id_user = valt;
    END LOOP;
    RETURN valt2.id_cust;
    ELSE
    RETURN 0;
    END if;
END;
/
CREATE OR REPLACE FUNCTION id_cust(Nom VARCHAR)
RETURN INT IS
CURSOR idcus IS
SELECT id_cust from Customers C
JOIN Users U
ON U.id_user = C.id_user
where  U.username = Nom;
entier INT;
BEGIN
OPEN idcus;
FETCH idcus into entier;
RETURN entier;
END;
/

CREATE OR REPLACE FUNCTION nom_restaurant(rst VARCHAR)
RETURN INT IS
CURSOR nom IS
select id_resto from Restaurant where Name_resto = rst;
idrst INT;
BEGIN
OPEN nom;
FETCH nom INTO idrst;
CLOSE nom;
RETURN idrst;
END;
/

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

DECLARE
PROCEDURE operation
AS
    varnomFonc int := custFonc('&Enter_Your_Username');
BEGIN
    DELETE FROM Panier
    WHERE id_cust = varnomFonc;
END;
BEGIN
insert into Orders(id_order,order_date,id_resto,id_panier)
VALUES
(id_order_seq.nextval,SYSDATE,nom_restaurant('&Nom_du_restaurant'),idpan('&Enter_Your_User_Name'));
operation;
END;
/
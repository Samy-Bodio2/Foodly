DECLARE
PROCEDURE operation
AS
    varnomFonc int := custFonc('&Enter_Your_Username');
BEGIN
    DELETE FROM Panier
    WHERE id_cust = varnomFonc;
    DELETE FROM Customers
    WHERE id_cust = varnomFonc;
END;
BEGIN
insert into Orders(id_order,order_date,id_resto,id_panier)
VALUES
(id_order_seq.nextval,SYSDATE,nom_restaurant('&Nom_du_restaurant'),id_panier_seq.currval);
operation;
END;
/

@Features/Features_customer/Menu_customer
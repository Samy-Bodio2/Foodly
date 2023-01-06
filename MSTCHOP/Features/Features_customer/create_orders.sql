DECLARE
PROCEDURE operation
AS
    varnomFonc int := id_cust('&Enter_Your_Username');
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
@Features/Features_customer/Menu_customer







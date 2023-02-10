CREATE OR REPLACE TRIGGER Customers_tg
BEFORE INSERT ON  Customers 
FOR EACH ROW
BEGIN
:new.id_cust := id_cust_seq.nextval;
END;
/
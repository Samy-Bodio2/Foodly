COMMENT ON TABLE customers
IS 'Allows you to add users.'

COMMENT ON COLUMN Customers.id_cust  
IS 'Primary key of Customers table.'

COMMENT ON COLUMN Customers.first_name  
IS 'Customer Name.'

COMMENT ON COLUMN Customers.last_name 
IS 'Prenom du client.'

COMMENT ON COLUMN Customers.phone_number 
IS 'Numero du client.'

COMMENT ON COLUMN Customers.Email 
IS 'Email du client.'

COMMENT ON COLUMN Customers.Datecd_cust  
IS 'Date de creation du compte client.'

COMMENT ON COLUMN Customers.Cust_address  
IS 'Addresse du client.'

COMMENT ON COLUMN Customers.id_user 
IS 'Foreign key of Customers table reference of Users table.'

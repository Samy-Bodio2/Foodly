COMMENT ON TABLE customers
IS 'Allows you to add users.'

COMMENT ON COLUMN Customers.id_cust  
IS 'Primary key of Customers table.'

COMMENT ON COLUMN Customers.first_name  
IS 'Customer Fisrt Name.'

COMMENT ON COLUMN Customers.last_name 
IS 'Customer Last Name.'

COMMENT ON COLUMN Customers.phone_number 
IS 'Customer number.'

COMMENT ON COLUMN Customers.Email 
IS 'Customer Email.'

COMMENT ON COLUMN Customers.Datecd_cust  
IS 'Date creation of the customer account.'

COMMENT ON COLUMN Customers.Cust_address  
IS 'Customer address.'

COMMENT ON COLUMN Customers.id_user 
IS 'Foreign key of Customers table reference of Users table.'

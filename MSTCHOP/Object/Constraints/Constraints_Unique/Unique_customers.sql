ALTER TABLE Customers
ADD CONSTRAINT cust_unique UNIQUE (Email,phone_number);
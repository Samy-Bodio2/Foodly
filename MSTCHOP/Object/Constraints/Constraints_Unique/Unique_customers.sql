ALTER TABLE Customers
ADD CONSTRAINT cust_unique UNIQUE (Email);

ALTER TABLE Customers
ADD CONSTRAINT cust_unique UNIQUE (phone_number);


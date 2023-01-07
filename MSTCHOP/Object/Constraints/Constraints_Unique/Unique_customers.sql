ALTER TABLE Customers
ADD CONSTRAINT email_unique UNIQUE (Email);

ALTER TABLE Customers
ADD CONSTRAINT phone_unique UNIQUE (phone_number);


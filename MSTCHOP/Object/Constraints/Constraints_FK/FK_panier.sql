ALTER TABLE Panier
ADD
	CONSTRAINT fk_id_customer
		FOREIGN KEY (id_cust)
		REFERENCES Customers(id_cust)
		ON DELETE CASCADE;
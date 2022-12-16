ALTER TABLE Choix
ADD ( 
		CONSTRAINT Quantity_chk CHECK(quantity > 0)
);
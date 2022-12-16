ALTER TABLE Note
ADD       
    CONSTRAINT fk_id_cust
        FOREIGN KEY (id_cust)
        REFERENCES Customers(id_cust);

ALTER TABLE Note
ADD       
    CONSTRAINT fk_id_restau
        FOREIGN KEY (id_resto)
        REFERENCES Restaurant(id_resto);

            

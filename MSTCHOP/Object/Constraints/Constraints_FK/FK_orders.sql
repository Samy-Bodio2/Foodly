ALTER TABLE Orders
ADD 
    CONSTRAINT fk_id_panier
        FOREIGN KEY (id_panier)
        REFERENCES Panier(id_panier)
        ON DELETE CASCADE;



ALTER TABLE Orders
ADD 
    CONSTRAINT fk_id_restaurant
        FOREIGN KEY (id_resto)
        REFERENCES Restaurant(id_resto)
        ON DELETE CASCADE;

ALTER TABLE Orders
ADD 
    CONSTRAINT fk_id_panier
        FOREIGN KEY (id_panier)
        REFERENCES Panier(id_panier)
        ON DELETE CASCADE;



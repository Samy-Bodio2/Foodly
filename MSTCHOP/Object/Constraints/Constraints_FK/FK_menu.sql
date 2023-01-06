ALTER TABLE Menu
ADD
    CONSTRAINT fk_id_dish
        FOREIGN KEY(id_dish)
        REFERENCES Dish(id_dish)
        ON DELETE CASCADE;

ALTER TABLE Menu
ADD
    CONSTRAINT fk_id_seculant
        FOREIGN KEY(id_seculant)
        REFERENCES Seculant(id_seculant)
        ON DELETE CASCADE;

ALTER TABLE Menu
ADD
    CONSTRAINT fk_id_garnish 
        FOREIGN KEY(id_garnish )
        REFERENCES Garnish(id_garnish )
        ON DELETE CASCADE;

ALTER TABLE Menu
ADD
    CONSTRAINT fk_id_resto
        FOREIGN KEY(id_resto)
        REFERENCES Restaurant(id_resto)
        ON DELETE CASCADE;

ALTER TABLE Menu
ADD
    CONSTRAINT fk_id_config
        FOREIGN KEY(id_config)
        REFERENCES Config(id_config)
        ON DELETE CASCADE;
        

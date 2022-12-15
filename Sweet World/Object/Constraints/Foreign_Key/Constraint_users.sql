ALTER TABLE Users
ADD
    CONSTRAINT fk_id_admin
        FOREIGN KEY(id_admin)
             REFERENCES ADMIN(id_admin);
/* Cree par Samy Bodio */
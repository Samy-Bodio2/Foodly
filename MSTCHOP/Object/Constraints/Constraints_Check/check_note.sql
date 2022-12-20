ALTER TABLE Note
    ADD (
        CONSTRAINT CHK_Note_valeur CHECK(Valeur BETWEEN 0 AND 10)
    );
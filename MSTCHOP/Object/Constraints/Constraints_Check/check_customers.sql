ALTER TABLE Customers
    ADD (
        CONSTRAINT CHK_Customers_phone CHECK (
        phone_number like '6________'),
        CONSTRAINT CHK_Customers_Email CHECK(
            Email like '%@%.%'
        )
        );
    
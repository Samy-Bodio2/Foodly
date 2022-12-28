CREATE TABLE Customers
(
    id_cust      INT          NOT NULL,
    first_name   VARCHAR(25)  NOT NULL,
    last_name    VARCHAR(25)  NOT NULL,
    Email        VARCHAR(30)  NOT NULL,
    phone_number NUMBER       NOT NULL,
    Cust_address VARCHAR(40)  NOT NULL,
    Gender       VARCHAR(1),
    Start_date   DATE         NOT NULL,
    id_user      INT          NOT NULL
);


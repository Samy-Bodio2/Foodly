CREATE TABLE Restaurant
    ( 
      id_resto         INT           NOT NULL,
      name_resto       VARCHAR(30)   NOT NULL,
      Description      VARCHAR(40),
      email            VARCHAR(40)   NOT NULL,
      phone_number     INT           NOT NULL,
      resto_address    VARCHAR(50)   NOT NULL,
      id_user          INT           NOT NULL   
    );

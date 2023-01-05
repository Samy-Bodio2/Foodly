CREATE TABLE Restaurant
    ( 
      id_resto         INT           NOT NULL,
      name_resto       VARCHAR(35)   NOT NULL,
      Description      VARCHAR(40),
      email            VARCHAR(30)   NOT NULL,
      phone_number     INT           NOT NULL,
      resto_address    VARCHAR(35)   NOT NULL,
      id_user          INT           NOT NULL   
    );

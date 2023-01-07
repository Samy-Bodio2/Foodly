ALTER TABLE Customers
ADD                  
    CONSTRAINT fk_id_user
        FOREIGN KEY (id_user)
            REFERENCES Users(id_user);
            
ALTER TABLE Restaurant
ADD
	CONSTRAINT fk_Users
		FOREIGN KEY (id_user)
		REFERENCES Users(id_user);

--***********BY TATSINKOU**********--
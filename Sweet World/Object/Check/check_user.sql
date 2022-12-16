ALTER TABLE Users
ADD ( 
		CONSTRAINT password_chk  CHECK( LENGTH(password) >= 9 )
);
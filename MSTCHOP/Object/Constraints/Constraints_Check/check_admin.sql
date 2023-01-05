ALTER TABLE Admin
ADD ( 
		CONSTRAINT password_chks  CHECK( LENGTH(pwd_admin) >= 9 )
);
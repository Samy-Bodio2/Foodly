ALTER TABLE [ADMIN]
ADD ( 
		CONSTRAINT pwd_admin_chk  CHECK( LENGTH(pwd_admin) >= 9 )
);
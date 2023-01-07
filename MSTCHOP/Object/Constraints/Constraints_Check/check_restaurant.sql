ALTER TABLE Restaurant
ADD ( 
		CONSTRAINT CHK_phone_number CHECK(phone_number LIKE '6________'),
		CONSTRAINT CHK_resto_Email CHECK( email like '%@%.%')
);
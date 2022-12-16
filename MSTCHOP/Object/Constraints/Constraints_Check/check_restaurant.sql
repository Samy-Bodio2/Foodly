ALTER TABLE Restaurant
ADD ( 
		CONSTRAINT phone_number CHECK(phone_number LIKE '6________')
);
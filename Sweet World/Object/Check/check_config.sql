ALTER TABLE Config
ADD ( 
		CONSTRAINT marge_chk CHECK(marge BETWEEN 0 AND 1),
		CONSTRAINT freight_costs_chk CHECK(freight_costs > 0)
);
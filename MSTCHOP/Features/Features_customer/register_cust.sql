BEGIN
sp_register_admin (p_id_user => id_user_seq.NEXTVAL,
             p_username => '&username',   
             p_password => format1('&password')                      
             );
END;
/

INSERT INTO Customers(id_cust,first_name,last_name,Email,phone_number,Cust_address,Gender,Start_date,id_user)
VALUES
(id_customers_seq.nextval,
'&first_name',
'&last_name',
'&email',
'&phone_number',
'&cust_address',
'&gender',
TO_DATE(SYSDATE, 'DD/MM/YYYY'),
idutil('&Enter_your_Username')
);

SELECT * FROM customers c JOIN Users u ON (c.id_user = u.id_user);

@Features/Features_customer/Menu_customer

 set linesize 3000;
 INSERT INTO utilisateur
  (utilisateur_id, 
  utilisateur_email, 
  password) 
VALUES 
  (seq_user.nextval, 
   '&utilisateur_email', 
  '&password');
  select * from utilisateur;

 INSERT INTO customers(customer_id, 
      customer_firstname,
      customer_lastname,
      customer_email,
      customer_phone ,
      customer_address,
      customer_gender,
      customer_start_date ,
      utilisateur_id  )
    VALUES
    ( seq_cust.nextval,
     '&customer_firstname',
      '&customer_lastname',
      '&customer_email',
      &customer_phone ,
      '&customer_address',
      '&customer_gender',
      TO_CHAR (SYSDATE,'dd/mm/yyyy'),
      &utilisateur_id);

select * from customers;


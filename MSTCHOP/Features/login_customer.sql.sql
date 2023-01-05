SELECT username, password
FROM Customers c
JOIN Users u
ON(c.id_user = u.id_user)
WHERE username = '&username' AND pssword = '&password';

@Features/Features_customer/Menu_customer
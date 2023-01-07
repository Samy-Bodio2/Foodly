SELECT u.username, u.password
FROM Customers c
JOIN Users u
ON(c.id_user = u.id_user)
WHERE u.username = '&username' AND u.password = format1('&password');

@Features/Features_customer/Menu_customer
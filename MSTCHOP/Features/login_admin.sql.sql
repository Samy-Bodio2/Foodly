SELECT username, password
FROM Admin a 
JOIN Users u
ON(a.id_user = u.id_user)
WHERE username = '&username' AND pssword = '&password';

@Features/Features_admin/Menu_admin
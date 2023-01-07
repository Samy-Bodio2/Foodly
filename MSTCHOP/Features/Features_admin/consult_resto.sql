
DECLARE
CURSOR resto IS
select Name_resto , Description , email , phone_number, resto_address 
from Restaurant ;
PROCEDURE consulter_les_restaurants AS
V_resto_nom Restaurant%ROWTYPE; 
V_Description Restaurant%ROWTYPE;
V_email Restaurant%ROWTYPE;
V_phone_number Restaurant%ROWTYPE;
V_resto_address  Restaurant%ROWTYPE; 
BEGIN 
OPEN resto;
LOOP
FETCH resto into V_resto_nom.Name_resto,V_Description.Description,V_email.email,V_phone_number.phone_number,V_resto_address.resto_address;
    EXIT WHEN resto%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Nom du Restaurant: '||V_resto_nom.Name_resto||'  '||'Sa description: '||V_Description.Description
    ||'  '||'Email: '||V_email.email||'  '||'Phone Number: '||V_phone_number.phone_number||'  '||'Adresse: '||V_resto_address.resto_address);
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------------------------------------------------------------------------------------');
END LOOP;
END;
BEGIN
    consulter_les_restaurants;
END;
/

@Features/Features_admin/Menu_admin
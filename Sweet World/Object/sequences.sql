drop sequence seq_seculant;
drop sequence seq_dish;
drop sequence seq_garnish;
drop sequence seq_user;
drop sequence seq_note;
drop sequence seq_panier;
drop sequence seq_cust;
drop sequence seq_resto;
drop sequence seq_order;
drop sequence seq_menu;
drop sequence seq_choix;
drop sequence seq_config;

-- objet sequence du seculant
create sequence seq_seculant
start with 100
increment by 1;

-- objet sequence du dish
create sequence seq_dish
start with 100
increment by 1;

-- objet sequence du garnish
create sequence seq_garnish
start with 100
increment by 1;

-- objet sequence du user
create sequence seq_user
start with 100
increment by 1;

-- objet sequence du note
create sequence seq_note
start with 100
increment by 1;

-- objet sequence du panier
create sequence seq_panier
start with 100
increment by 1;

-- objet sequence du customer
create sequence seq_cust
start with 100
increment by 1;

-- objet sequence du restaurant
create sequence seq_resto
start with 100
increment by 1;

-- objet sequence du order
create sequence seq_order
start with 100
increment by 1;

-- objet sequence du menu
create sequence seq_menu
start with 100
increment by 1;


-- objet sequence du choix
create sequence seq_choix
start with 100
increment by 1;

-- objet sequence de config
create sequence seq_config
start with 100
increment by 1;


CREATE OR REPLACE PACKAGE utilisateur_security AS

    FUNCTION GET_HASH   (utilisateur_email   IN  VARCHAR2,
                         password  IN  VARCHAR2)
        RETURN VARCHAR2;
        
    PROCEDURE add_user   (utilisateur_email IN  VARCHAR2,
                         password  IN  VARCHAR2);

    PROCEDURE change_password   (utilisateur_email     IN  VARCHAR2,
                                 old_password  IN  VARCHAR2,
                                 new_password  IN  VARCHAR2);

    PROCEDURE valid_user   (utilisateur_email IN  VARCHAR2,
                           password  IN  VARCHAR2);

    FUNCTION valid_user   (utilisateur_email IN  VARCHAR2,
                          password  IN  VARCHAR2)
        RETURN BOOLEAN;

    END;
/
CREATE OR REPLACE PACKAGE BODY utilisateur_security AS

      FUNCTION GET_HASH (utilisateur_email  IN  VARCHAR2,
                         password  IN  VARCHAR2);
       RETURN VARCHAR2 AS
        v_secur VARCHAR2(30) := 'Test';
      BEGIN
        -- Pre Oracle 10g
      -- RETURN DBMS_OBFUSCATION_TOOLKIT.MD5(
        --  input_string => UPPER(utilisateur_email) || v_secur || UPPER(password));

        -- Oracle 10g+ : Require EXECUTE on DBMS_CRYPTO
       RETURN DBMS_CRYPTO.HASH(UTL_RAW.CAST_TO_RAW(UPPER(utilisateur_email) 
		|| v_secur || UPPER(password)),DBMS_CRYPTO.HASH_SH1);
     END;
/
/*
      PROCEDURE add_user (utilisateur_email  IN  VARCHAR2,
                          password  IN  VARCHAR2) AS
      BEGIN
        INSERT INTO utilisateur (
          id_user,
          utilisateur_email,
          password
        )
        VALUES (
          utilisateur_seq.NEXTVAL,
          UPPER(utilisateur_email),
          GET_HASH(utilisateur_email, password)
        );
        
        COMMIT;
      END;
      / */
      /*
      PROCEDURE change_password (utilisateur_email      IN  VARCHAR2,
                                 old_password  IN  VARCHAR2,
                                 new_password  IN  VARCHAR2) AS
        v_rowid  ROWID;
      BEGIN
        SELECT rowid
        INTO   v_rowid
        FROM   utilisateur
        WHERE  utilisateur_email = UPPER(utilisateur_email)
        AND    password = get_hash(utilisateur_email, p_old_password)
        FOR UPDATE;
        
        UPDATE utilisateur
        SET    password = get_hash(utilisateur_email, p_new_password)
        WHERE  rowid    = v_rowid;
        
        COMMIT;
      EXCEPTION
        WHEN NO_DATA_FOUND THEN
          RAISE_APPLICATION_ERROR(-20010, 'nom utilisateur/mot de passe incorrect.');
      END;

      PROCEDURE valid_user (utilisateur_email  IN  VARCHAR2,
                            password  IN  VARCHAR2) AS
        v_numy  VARCHAR2(1);
      BEGIN
        SELECT '1'
        INTO   v_numy
        FROM   utilisateur
        WHERE  utilisateur_email = UPPER(utilisateur_email)
        AND    password = get_hash(utilisateur_email, password);
      EXCEPTION
        WHEN NO_DATA_FOUND THEN
          RAISE_APPLICATION_ERROR(-20000, 'nom utilisateur/mot de passe incorrect.');
      END;
      
      FUNCTION valid_user (utilisateur_email  IN  VARCHAR2,
                           password  IN  VARCHAR2) 
        RETURN BOOLEAN AS
      BEGIN
        valid_user(utilisateur_email, password);
        RETURN TRUE;
      EXCEPTION
        WHEN OTHERS THEN
          RETURN FALSE;
      END;
      
    */
    






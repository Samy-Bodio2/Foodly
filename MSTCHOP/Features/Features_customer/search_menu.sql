SET SERVEROUTPUT ON;
DECLARE

    name_menu varchar(50);
    result_menu varchar(50);
    v_menu Menu%ROWTYPE;

    PROCEDURE select_menu(mn IN VARCHAR) AS
        BEGIN
            SELECT Menu_title INTO v_menu FROM Menu WHERE Menu_title = mn;
                DBMS_OUTPUT.PUT_LINE(menu.id_menu ||'   '||menu.Menu_title);
        END;

BEGIN
    result_menu := lower('&menu');
        IF result_menu like '%okok%' or result_menu like '%lokok%' or result_menu like '%leko%' or result_menu like '%lekok%'
            or result_menu like '%lecoq%' or result_menu like '%locoq%' or result_menu like '%lecok%' or result_menu like '%lecoc%'
            or result_menu like '%lococ%' or result_menu like '%ecoc%' or result_menu like '%ococ%' or result_menu like '%le coq%'
            or result_menu like '%le kok%' or result_menu like '%lo kok%' or result_menu like '%leokok%' or result_menu like '%eqoc%'
            or result_menu like '%oqoc%' or result_menu like '%leqoq%' or result_menu like '%leqoc%' or result_menu like '%loqoc%'
            or result_menu like '%e kok%' or result_menu like '%o kok%' or result_menu like '%kok%' or result_menu like '%coq%'
            or result_menu like '%ikok%' or result_menu like '%likok%' or result_menu like '%licoc%' or result_menu like '%likoq%'
            or result_menu like '%le qoc%' or result_menu like '%le koq%' or result_menu like '%le qok%' THEN
            name_menu := 'Okok';
            select_menu(name_menu);
        END IF;

        IF result_menu like '%bekwam%' or result_menu like '%bekwan%' or result_menu like '%bequan%' or result_menu like '%bekuan%'
            or result_menu like '%becuan%' or result_menu like '%bekuan%' or result_menu like '%bekwuan%'
            or result_menu like '%bequam%' or result_menu like '%bekuam%' or result_menu like '%singe%'
            or result_menu like '%becuam%' or result_menu like '%bekuam%' or result_menu like '%bekwuam%' THEN
            name_menu := 'Bekwam';
            select_menu(name_menu);
        END IF;

        IF result_menu like '%eru%' or result_menu like '%erru%' or result_menu like '%herru%' or result_menu like '%herro%' 
            or result_menu like '%heros%' or result_menu like '%hero%' or result_menu like '%herros%' or result_menu like '%viande%'
            or result_menu like '%heru%' or result_menu like '%herrus%' or result_menu like '%eros%' or result_menu like '%erus%'
            or result_menu like '%ero%' THEN
            name_menu := 'Eru';
            select_menu(name_menu);
            END IF;

        IF result_menu like '%wrap%' or result_menu like '%jambon%' or result_menu like '%wrap au jambon%' or result_menu like '%vrap%'
            or result_menu like '%vap%' or result_menu like '%rap%' or result_menu like '%janbon%' or result_menu like '%porc%' or result_menu like '%viande%' THEN
            result_menu := 'wrap au jambon';
            select_menu(result_menu);
        END IF;

        IF result_menu like '%porc%' or result_menu like '%por%' or result_menu like '%viande%' or result_menu like '%brochette%'
            or result_menu like '%brochettes%' or result_menu like '%brochet%' or result_menu like '%broche%' or result_menu like '%brochette de porc%' THEN
            name_menu := 'Brochettes de porc';
            select_menu(name_menu);
        END IF;

        IF result_menu like '%tacos%' or result_menu like '%steak%' or result_menu like '%tomate%'
            or result_menu like '%pain%' or result_menu like '%boeuf%' or result_menu like '%viande%'
            or result_menu like '%poulet%' or result_menu like '%hambourg%' or result_menu like '%avocat%'
            or result_menu like '%kebab%' or result_menu like '%fromage%' or result_menu like '%fast food%'
            or result_menu like '%nourritue%' or result_menu like '%snack%' THEN
            name_menu := 'Tacos';
            select_menu(name_menu);
        END IF;

        IF result_menu like '%pizza%' or result_menu like '%vegetarien%' or result_menu like '%patte%'
            or result_menu like '%pizza famille%' or result_menu like '%pizza vegetarienne%' 
            or result_menu like '%pizza végetarien%'
            or result_menu like '%pizza vegetarien%' or result_menu like '%légume%' or result_menu like '%pizza végetarienne%'
            or result_menu like '%croutte%' THEN
            name_menu :=  'Pizza vegetarienne';
            select_menu(name_menu);
        END IF;

        IF result_menu like '%cheese burger%' or result_menu like '%burger%'
            or result_menu like '%sandwich%' or result_menu like '%hamburger%'
            or result_menu like '%pain%' 
            or result_menu like '%cheese%' or result_menu like '%hambourg%' 
            or result_menu like '%kebab%' or result_menu like '%fromage%' or result_menu like '%fast food%'
            or result_menu like '%nourritue%' or result_menu like '%snack%' or result_menu like '%macdo%' THEN
            name_menu := 'Big size burger';
            select_menu(name_menu);
        END IF;

        IF result_menu like '%dolait%' or result_menu like '%ndole%' or result_menu like '%dole%'
            or result_menu like '%ndolait%' or result_menu like '%dolet%' or result_menu like '%dhole%'
            or result_menu like '%nndole%' or result_menu like '%elodn%' or result_menu like '%mbole%'
            or result_menu like '%ntole%' or result_menu like '%viande%' or result_menu like '%poisson%' THEN
            name_menu := 'Ndole';
            select_menu(name_menu);
        END IF;

        IF result_menu like '%cheese burger%' or result_menu like '%burger%'
            or result_menu like '%sandwich%' or result_menu like '%hamburger%'
            or result_menu like '%pain%' 
            or result_menu like '%cheese%' or result_menu like '%hambourg%' 
            or result_menu like '%kebab%' or result_menu like '%fromage%' or result_menu like '%fast food%'
            or result_menu like '%nourritue%' or result_menu like '%snack%' or result_menu like '%macdo%' THEN
            name_menu := 'Hamburger avec des frites + sauce';
            select_menu(name_menu);
        END IF;

        IF result_menu like '%poule%' or result_menu like '%braise%'
            or result_menu like '%bese%' or result_menu like '%baise%'
            or result_menu like '%brese%' 
            or result_menu like '%poul%' or result_menu like '%poulaid%' 
            or result_menu like '%viande%' or result_menu like '%feu%' THEN
            name_menu := 'Poulet braise';
            select_menu(name_menu);
        END IF;

        IF result_menu like '%sanga%' or result_menu like '%nsanga%' or result_menu like '%saga%' or result_menu like '%senga%'
            or result_menu like '%cenga%' or result_menu like '%canga%' or result_menu like '%zanga%' or result_menu like '%le sanga%'
            or result_menu like '%tsanga%' or result_menu like '%mais%' or result_menu like '%maïs%' THEN
            name_menu := 'Sanga';
            select_menu(name_menu);
        END IF;

        IF result_menu like '%mitumba%' or result_menu like '%mitoumba%' or result_menu like '%mintounba%'
            or result_menu like '%mitouba%' or result_menu like '%mintumba%' or result_menu like '%mituba%' 
            or result_menu like '%mintoumba%' or result_menu like '%mintuba%' or result_menu like '%mintunba%' THEN
            name_menu := 'Mitumba';
            select_menu(name_menu);
        END IF;

        IF result_menu like '%poisson%' or result_menu like '%Gamba%'  THEN
            name_menu := 'Gamba Poisson Capi';
            select_menu(name_menu);
        END IF;

        IF result_menu like '%legume%' or result_menu like '%salade%' THEN
            name_menu := 'Salade au coq marine';
            select_menu(name_menu);
        END IF;

        IF result_menu like '%romaine%'  THEN
            name_menu := 'La romaine italienne';
            select_menu(name_menu);
        END IF;
END;
/


--------------------Jason Kamsu

@Features/Features_customer/Menu_customer
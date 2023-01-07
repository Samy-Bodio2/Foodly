CREATE OR REPLACE PROCEDURE note_restaurant
v_id_note Note.id_note%TYPE,
v_Valeur Note.Valeur%TYPE,
v_id_cust Note.id_cust%TYPE,
v_id_resto Note.id_resto%TYPE
AS
BEGIN

INSERT INTO Note
    (
    id_note,
    Valeur,
    id_cust,
    id_resto
    )
VALUES
    (
    v_id_note = id_note_seq.nextval,
    v_Valeur,
    v_id_cust,
    v_id_resto
    );
END;
/


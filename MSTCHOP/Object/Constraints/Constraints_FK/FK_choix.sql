ALTER TABLE Choix
ADD 
    CONSTRAINT ch_pan_fk 
    FOREIGN KEY (id_panier)
    REFERENCES Panier(id_panier);
    
 ALTER TABLE Choix   
ADD 
    CONSTRAINT ch_men_fk 
    FOREIGN KEY (id_menu)
    REFERENCES Menu(id_menu);

package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "intrant")
public class Intrant {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nom;

    private String numeroLot;

    public int getId(){
        return this.id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNumeroLot(String numeroLot) {
        this.numeroLot = numeroLot;
    }

    public String getNumeroLot() {
        return this.numeroLot;
    }
}

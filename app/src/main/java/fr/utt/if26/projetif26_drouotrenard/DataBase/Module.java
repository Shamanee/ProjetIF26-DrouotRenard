package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "module",
        indices = {@Index("id")},
        foreignKeys = @ForeignKey(
                entity = Ligne.class,
                parentColumns = "id",
                childColumns = "ligne_id"
        ))
public class Module {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nom;

    @ColumnInfo(name = "ligne_id")
    public int ligneId;

    public Module(String nom, int ligneId) {
        this.nom = nom;
        this.ligneId = ligneId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setLigneId(int ligneId) {
        this.ligneId = ligneId;
    }

    public int getLigneId() {
        return this.ligneId;
    }
}

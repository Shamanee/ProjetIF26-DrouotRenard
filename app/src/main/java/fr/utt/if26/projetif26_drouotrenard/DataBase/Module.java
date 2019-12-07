package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "module",
        indices = {@Index("id")},
        foreignKeys = @ForeignKey(
                entity = Modele.class,
                parentColumns = "id",
                childColumns = "modele_id"
        ))
public class Module {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nom;

    @ColumnInfo(name = "modele_id")
    public int modeleId;

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

    public void setModeleId(int modeleId) {
        this.modeleId = modeleId;
    }

    public int getModeleId() {
        return this.modeleId;
    }
}

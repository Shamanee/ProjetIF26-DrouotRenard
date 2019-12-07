package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "modele",
        indices = {@Index("id")}
)
public class Modele {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private Date dlc;

    private int quantite;

    private Date createdAt = null;

    private Date updatedAt = null;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public Date getDlc() {
        return this.dlc;
    }

    public void setDlc(Date dlc) {
        this.dlc = dlc;
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

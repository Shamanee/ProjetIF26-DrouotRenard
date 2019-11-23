package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "feuille")
public class Feuille {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private boolean isActive;

    private Date createdAt;

    private Date updatedAt;

    public int getId() {
        return this.id;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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

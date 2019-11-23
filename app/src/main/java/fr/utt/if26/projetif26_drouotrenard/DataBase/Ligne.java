package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "ligne",
        foreignKeys = @ForeignKey(
                entity = Module.class,
                parentColumns = "id",
                childColumns = "module_id"
        ))
public class Ligne {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String objectif;

    private String reel;

    @ColumnInfo(name = "module_id")
    public int moduleId;

    public int getId() {
        return this.id;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getObjectif() {
        return this.objectif;
    }

    public void setReel(String reel) {
        this.reel = reel;
    }

    public String getReel() {
        return this.reel;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getModuleId() {
        return this.moduleId;
    }
}

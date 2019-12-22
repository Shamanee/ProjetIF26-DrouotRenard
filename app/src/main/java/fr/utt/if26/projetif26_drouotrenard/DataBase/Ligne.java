package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "ligne",
        foreignKeys = @ForeignKey(
//                entity = Module.class,
//                parentColumns = "id",
//                childColumns = "module_id"
                entity = Parametre.class,
                parentColumns = "id",
                childColumns = "parametreId",
                onDelete = ForeignKey.CASCADE
        )
)
public class Ligne {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String numeroSerie;

    private String objectif;

    private String reel;

//    @ColumnInfo(name = "module_id")
//    public int moduleId;

    public int parametreId;

    public Ligne(String numeroSerie, String objectif, String reel, int parametreId) {
        this.numeroSerie = numeroSerie;
        this.objectif = objectif;
        this.reel = reel;
        this.parametreId = parametreId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getNumeroSerie() {
        return this.numeroSerie;
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

//    public void setModuleId(int moduleId) {
//        this.moduleId = moduleId;
//    }
//
//    public int getModuleId() {
//        return this.moduleId;
//    }

//    public void setParametreId(int parametreId) {
//        this.parametreId = parametreId;
//    }
//
//    public int getParametreId() {
//        return this.parametreId;
//    }
}

package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "parametre",
        foreignKeys = {
            @ForeignKey(
                    entity = Intrant.class,
                    parentColumns = "id",
                    childColumns = "intrant_id"),
//            @ForeignKey(
//                    entity = Ligne.class,
//                    parentColumns = "id",
//                    childColumns = "ligne_id"
//            )
}
            )
public class Parametre {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String type;

    private String value;

    @ColumnInfo(name = "intrant_id")
    public int intrantId;

//    @ColumnInfo(name = "ligne_id")
//    public int ligneId;

    public Parametre(String type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setIntrantId(int intrantId) {
        this.intrantId = intrantId;
    }

    public int getIntrantId() {
        return this.intrantId;
    }

//    public void setLigneId(int ligneId) {
//        this.ligneId = ligneId;
//    }
//
//    public int getLigneId() {
//        return this.ligneId;
//    }

    public static Parametre[] populateData() {
        return new Parametre[] {
          new Parametre("Temperature"),
          new Parametre("Acidite"),
          new Parametre("pH"),
          new Parametre("Temps")
        };
    }

    @Override
    public String toString() {
        return type;
    }
}

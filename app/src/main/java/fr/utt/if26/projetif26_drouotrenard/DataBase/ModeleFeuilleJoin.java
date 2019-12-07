package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "modele_feuille",
        primaryKeys = {"modele_id","feuille_id"},
        foreignKeys = {
            @ForeignKey(
                    entity = Modele.class,
                    parentColumns = "id",
                    childColumns = "modele_id"),
            @ForeignKey(
                    entity = Feuille.class,
                    parentColumns = "id",
                    childColumns = "feuille_id"
            )})
public class ModeleFeuilleJoin {

    @ColumnInfo(name = "modele_id")
    public int modeleId;

    @ColumnInfo(name = "feuille_id")
    public int feuilleId;

}

package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ModeleFeuilleJoinDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ModeleFeuilleJoin modeleFeuilleJoin);

    @Update
    void update(ModeleFeuilleJoin modeleFeuilleJoin);

    @Query("SELECT * FROM modele " +
            "INNER JOIN modele_feuille " +
            "ON modele.id=modele_feuille.modele_id " +
            "WHERE modele_feuille.feuille_id=:feuilleId")
    LiveData<List<Modele>> getModeleForFeuille(final int feuilleId);

    @Query("SELECT * FROM feuille " +
            "INNER JOIN modele_feuille " +
            "ON feuille.id=modele_feuille.feuille_id " +
            "WHERE modele_feuille.modele_id=:modeleId")
    LiveData<List<Feuille>> getFeuilleForModele(final int modeleId);

}

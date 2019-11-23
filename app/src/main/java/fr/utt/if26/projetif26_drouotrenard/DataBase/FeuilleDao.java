package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FeuilleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Feuille feuille);

    @Update
    void update(Feuille feuille);

    @Query("DELETE FROM feuille WHERE id = :id")
    void deletebyId(int id);

    @Query("DELETE FROM feuille")
    void deleteAll();

    @Query("SELECT * FROM feuille")
    LiveData<List<Feuille>> getAll();

    @Query("SELECT * FROM feuille WHERE id = :id")
    Feuille getById(int id);

}

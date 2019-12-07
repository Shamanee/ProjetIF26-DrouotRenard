package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LigneDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Ligne ligne);

    @Update
    void update(Ligne ligne);

    @Query("DELETE FROM ligne WHERE id = :id")
    void deletebyId(int id);

    @Query("DELETE FROM ligne ")
    void deleteAll();

    @Query("SELECT * FROM ligne ")
    LiveData<List<Ligne>> getAll();

    @Query("SELECT * FROM ligne WHERE id = :id")
    Ligne getById(int id);

}

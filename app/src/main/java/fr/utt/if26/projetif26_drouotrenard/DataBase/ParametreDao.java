package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ParametreDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Parametre parametre);

    @Update
    void update(Parametre parametre);

    @Query("DELETE FROM parametre WHERE id = :id")
    void deletebyId(int id);

    @Query("DELETE FROM parametre")
    void deleteAll();

    @Query("SELECT * FROM parametre")
    LiveData<List<Parametre>> getAll();

    @Query("SELECT * FROM parametre WHERE id = :id")
    Parametre getById(int id);
    
}

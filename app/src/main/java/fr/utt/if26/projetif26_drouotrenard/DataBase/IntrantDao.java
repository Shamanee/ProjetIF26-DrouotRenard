package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IntrantDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Intrant intrant);

    @Update
    void update(Intrant intrant);

    @Query("DELETE FROM intrant WHERE id = :id")
    void deletedById(int id);

    @Query("DELETE FROM intrant")
    void deleteAll();

    @Query("SELECT * FROM intrant")
    LiveData<List<Intrant>> getAll();

    @Query("SELECT * FROM intrant WHERE id = :id")
    Intrant getById(int id);
}

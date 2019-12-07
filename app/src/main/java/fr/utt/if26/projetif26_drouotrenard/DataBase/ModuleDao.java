package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ModuleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Module module);

    @Update
    void update(Module module);

    @Query("DELETE FROM module WHERE id = :id")
    void deletebyId(int id);

    @Query("DELETE FROM module")
    void deleteAll();

    @Query("SELECT * FROM module")
    LiveData<List<Module>> getAll();

    @Query("SELECT * FROM module WHERE id = :id")
    Module getById(int id);

}

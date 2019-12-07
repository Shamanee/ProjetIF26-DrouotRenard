package fr.utt.if26.projetif26_drouotrenard.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ModeleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Modele modele);

    @Update
    void update(Modele modele);

    @Query("DELETE FROM modele WHERE id = :id")
    void deletebyId(int id);

    @Query("DELETE FROM modele")
    void deleteAll();

    @Query("SELECT * FROM modele")
    LiveData<List<Modele>> getAll();

    @Query("SELECT * FROM modele WHERE id = :id")
    Modele getById(int id);

}

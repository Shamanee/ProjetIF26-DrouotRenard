package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ModeleRepository {

    private ModeleDao modeleDao;
    private LiveData<List<Modele>> allModeles;

    ModeleRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        modeleDao = db.modeleDao();
        allModeles = modeleDao.getAll();
    }

    LiveData<List<Modele>> getAllModeles() {
        return allModeles;
    }

    void insert(final Modele modele) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            modeleDao.insert(modele);
        });
    }
    
}

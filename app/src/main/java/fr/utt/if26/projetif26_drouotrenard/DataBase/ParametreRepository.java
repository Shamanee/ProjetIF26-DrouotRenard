package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ParametreRepository {

    private ParametreDao parametreDao;
    private LiveData<List<Parametre>> allParametres;

    ParametreRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        parametreDao = db.parametreDao();
        allParametres = parametreDao.getAll();
    }

    LiveData<List<Parametre>> getAllParametres() {
        return allParametres;
    }

    void insert(final Parametre parametre) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            parametreDao.insert(parametre);
        });
    }
    
}

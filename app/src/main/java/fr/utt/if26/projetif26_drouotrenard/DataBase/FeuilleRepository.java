package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class FeuilleRepository {

    private FeuilleDao feuilleDao;
    private LiveData<List<Feuille>> allFeuilles;

    FeuilleRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        feuilleDao = db.feuilleDao();
        allFeuilles = feuilleDao.getAll();
    }

    LiveData<List<Feuille>> getAllFeuilles() {
        return allFeuilles;
    }

    void insert(final Feuille feuille) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            feuilleDao.insert(feuille);
        });
    }

}

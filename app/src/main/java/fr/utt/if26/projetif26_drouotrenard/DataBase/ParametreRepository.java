package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.app.Application;
import android.os.AsyncTask;

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

    public void deleteById(int id) {
        new deleteAsyncTask(parametreDao).execute(id);
    }

    private static class deleteAsyncTask extends AsyncTask<Integer, Void, Void> {

        private ParametreDao asyncTaskDao;

        deleteAsyncTask(ParametreDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Integer... integers) {
            asyncTaskDao.deletebyId(integers[0]);
            return null;
        }
    }
    
}

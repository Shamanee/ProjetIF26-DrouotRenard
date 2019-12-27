package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LigneRepository {

    private LigneDao ligneDao;
    private LiveData<List<Ligne>> allLignes;

    LigneRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        ligneDao = db.ligneDao();
        allLignes = ligneDao.getAll();
    }

    LiveData<List<Ligne>> getAllLignes() {
        return allLignes;
    }

    void insert(final Ligne ligne) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            ligneDao.insert(ligne);
        });
    }

    public void deleteById(int id) {
        new deleteAsyncTask(ligneDao).execute(id);
    }

    private static class deleteAsyncTask extends AsyncTask<Integer, Void, Void> {

        private LigneDao asyncTaskDao;

        deleteAsyncTask(LigneDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Integer... integers) {
            asyncTaskDao.deletebyId(integers[0]);
            return null;
        }
    }

    public void updateById(int id, String numeroDeSerie, String objectif, String reel, int paramId){
        new updateAsyncTask(ligneDao, id, numeroDeSerie, objectif, reel, paramId).execute();
    }

    private static class updateAsyncTask extends AsyncTask<Void, Void, Void> {

        LigneDao asyncTaskDao;
        int id;
        String numeroDeSerie;
        String objectif;
        String reel;
        int paramId;

        updateAsyncTask(LigneDao dao, int id, String numeroDeSerie, String objectif, String reel, int paramId) {
            this.asyncTaskDao = dao;
            this.id = id;
            this.numeroDeSerie = numeroDeSerie;
            this.objectif = objectif;
            this.reel = reel;
            this.paramId = paramId;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            asyncTaskDao.updateById(id, numeroDeSerie, objectif, reel, paramId);
            return null;
        }
    }
}

package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ModuleRepository {

    private ModuleDao moduleDao;
    private LiveData<List<Module>> allModules;

    ModuleRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        moduleDao = db.moduleDao();
        allModules = moduleDao.getAll();
    }

    LiveData<List<Module>> getAllModules() {
        return allModules;
    }

    void insert(final Module module) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            moduleDao.insert(module);
        });
    }

    public void deleteById(int id) {
        new deleteAsyncTask(moduleDao).execute(id);
    }

    private static class deleteAsyncTask extends AsyncTask<Integer, Void, Void> {

        private ModuleDao asyncTaskDao;

        deleteAsyncTask(ModuleDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            asyncTaskDao.deletebyId(integers[0]);
            return null;
        }
    }

    public void updateById(int id, String nom, int ligneId) {
        new updateAsyncTask(moduleDao, id, nom, ligneId).execute();
    }

    private static class updateAsyncTask extends AsyncTask<Void, Void, Void> {

        ModuleDao asyncTaskDao;
        int id;
        String nom;
        int ligneId;

        updateAsyncTask(ModuleDao dao, int id, String nom, int ligneId) {
            this.asyncTaskDao = dao;
            this.id = id;
            this.nom = nom;
            this.ligneId = ligneId;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            asyncTaskDao.updateById(id, nom, ligneId);
            return null;
        }
    }
    
}

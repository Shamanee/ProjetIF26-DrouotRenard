package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.app.Application;

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
    
}

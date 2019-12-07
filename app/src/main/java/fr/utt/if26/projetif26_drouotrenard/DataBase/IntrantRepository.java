package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class IntrantRepository {

    private IntrantDao intrantDao;
    private LiveData<List<Intrant>> allIntrants;

    IntrantRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        intrantDao = db.intrantDao();
        allIntrants = intrantDao.getAll();
    }

    LiveData<List<Intrant>> getAllIntrants() {
        return allIntrants;
    }

    void insert(final Intrant intrant) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            intrantDao.insert(intrant);
        });
    }

}

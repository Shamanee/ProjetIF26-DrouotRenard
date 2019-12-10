package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ParametreViewModel extends AndroidViewModel {
    private ParametreRepository repository;

    private LiveData<List<Parametre>> allParametres;

    public ParametreViewModel(@NonNull Application application) {
        super(application);

        repository = new ParametreRepository(application);
        allParametres = repository.getAllParametres();
    }

    public LiveData<List<Parametre>> getAllParametres() {
        return  allParametres;
    }

    public void insert(Parametre parametre) {
        repository.insert(parametre);
    }
}

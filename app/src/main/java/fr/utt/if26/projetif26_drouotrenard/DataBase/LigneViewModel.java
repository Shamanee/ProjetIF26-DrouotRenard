package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class LigneViewModel extends AndroidViewModel {
    private LigneRepository repository;

    private LiveData<List<Ligne>> allLignes;

    public LigneViewModel(@NonNull Application application) {
        super(application);

        repository = new LigneRepository(application);
        allLignes = repository.getAllLignes();
    }

    public LiveData<List<Ligne>> getAllLignes() {
        return  allLignes;
    }

    public void insert(Ligne ligne) {
        repository.insert(ligne);
    }
}

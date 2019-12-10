package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FeuilleViewModel extends AndroidViewModel {

    private FeuilleRepository repository;

    private LiveData<List<Feuille>> allFeuilles;

    public FeuilleViewModel(@NonNull Application application) {
        super(application);

        repository = new FeuilleRepository(application);
        allFeuilles = repository.getAllFeuilles();
    }

    public LiveData<List<Feuille>> getAllFeuilles() {
        return  allFeuilles;
    }

    public void insert(Feuille feuille) {
        repository.insert(feuille);
    }
}

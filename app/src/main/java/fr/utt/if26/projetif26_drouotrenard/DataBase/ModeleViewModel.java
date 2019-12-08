package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ModeleViewModel extends AndroidViewModel {
    private ModeleRepository repository;

    private LiveData<List<Modele>> allModeles;

    public ModeleViewModel(@NonNull Application application) {
        super(application);

        repository = new ModeleRepository(application);
        allModeles = repository.getAllModeles();
    }

    LiveData<List<Modele>> getAllModeles() {
        return  allModeles;
    }

    public void insert(Modele modele) {
        repository.insert(modele);
    }
}

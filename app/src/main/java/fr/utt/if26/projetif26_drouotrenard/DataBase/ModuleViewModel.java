package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ModuleViewModel extends AndroidViewModel {
    private ModuleRepository repository;

    private LiveData<List<Module>> allModules;

    public ModuleViewModel(@NonNull Application application) {
        super(application);

        repository = new ModuleRepository(application);
        allModules = repository.getAllModules();
    }

    public LiveData<List<Module>> getAllModules() {
        return  allModules;
    }

    public void insert(Module module) {
        repository.insert(module);
    }

//    public void deleteByNom(String nom) {
//        repository.deleteByNom(nom);
//    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public void updateById(int id, String nom, int ligneId) {
        repository.updateById(id, nom, ligneId);
    }
}

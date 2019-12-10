package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class IntrantViewModel extends AndroidViewModel {

    private IntrantRepository repository;

    private LiveData<List<Intrant>> allIntrants;

    public IntrantViewModel(@NonNull Application application) {
        super(application);

        repository = new IntrantRepository(application);
        allIntrants = repository.getAllIntrants();
    }

    public LiveData<List<Intrant>> getAllIntrants() {
        return  allIntrants;
    }

    public void insert(Intrant intrant) {
        repository.insert(intrant);
    }
}

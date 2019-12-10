package fr.utt.if26.projetif26_drouotrenard.Utiliser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import fr.utt.if26.projetif26_drouotrenard.DataBase.Module;
import fr.utt.if26.projetif26_drouotrenard.DataBase.ModuleListAdapter;
import fr.utt.if26.projetif26_drouotrenard.DataBase.ModuleViewModel;
import fr.utt.if26.projetif26_drouotrenard.R;

public class Utiliser3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utiliser3);

        RecyclerView recyclerView = findViewById(R.id.utiliser3_recyclerView);

        final ModuleListAdapter adapter = new ModuleListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ModuleViewModel model = new ViewModelProvider(this).get(ModuleViewModel.class);

        model.getAllModules().observe(this, new Observer<List<Module>>() {
            @Override
            public void onChanged(List<Module> modules) {
                adapter.setModules(modules);
            }
        });
    }
}

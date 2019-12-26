package fr.utt.if26.projetif26_drouotrenard.Parametrer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import fr.utt.if26.projetif26_drouotrenard.DataBase.Module;
import fr.utt.if26.projetif26_drouotrenard.DataBase.ModuleListAdapter;
import fr.utt.if26.projetif26_drouotrenard.DataBase.ModuleViewModel;
import fr.utt.if26.projetif26_drouotrenard.R;
import fr.utt.if26.projetif26_drouotrenard.RecyclerItemClickListener;

public class Parametrer2ListActivity extends AppCompatActivity implements View.OnClickListener {

    private String lastClicked = "";
    private Button btnSupprimer;
    private Button btnEditer;
    private RecyclerView recyclerView;
    private ModuleViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrer2_list);

        btnSupprimer = findViewById(R.id.parametrer2List_supprimeButton);
        btnEditer = findViewById(R.id.parametrer2List_editButton);

        model = new ViewModelProvider(this).get(ModuleViewModel.class);

        final ModuleListAdapter adapter = new ModuleListAdapter(this);

        recyclerView = findViewById(R.id.parametrer2List_RecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        lastClicked = adapter.getModules().get(position).getNom();
                        for (int i = 0; i < recyclerView.getChildCount(); i++) {
                            View v = recyclerView.getChildAt(i);
                            v.setBackgroundColor(Color.TRANSPARENT);
                        }
                        view.setBackgroundColor(getResources().getColor(R.color.bestColor));
                    }
                })
        );

        model.getAllModules().observe(this, new Observer<List<Module>>() {
            @Override
            public void onChanged(List<Module> modules) {
                adapter.setModules(modules);
            }
        });

        btnSupprimer.setOnClickListener(this);
        btnEditer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.parametrer2List_supprimeButton:
                if(!lastClicked.equals("")){
                    model.deleteByNom(lastClicked);
                    Toast.makeText(this, lastClicked+" a été supprimé !", Toast.LENGTH_SHORT).show();
                    lastClicked = "";
                    for (int i = 0; i < recyclerView.getChildCount(); i++) {
                        View child = recyclerView.getChildAt(i);
                        child.setBackgroundColor(Color.TRANSPARENT);
                    }
                } else {
                    Toast.makeText(this, "Selectionner un module !", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.parametrer2List_editButton:
                Toast.makeText(this, "EDITION EN COURS DE DEV !", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

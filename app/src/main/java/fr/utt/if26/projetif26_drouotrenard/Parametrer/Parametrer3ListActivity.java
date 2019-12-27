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

import fr.utt.if26.projetif26_drouotrenard.DataBase.Ligne;
import fr.utt.if26.projetif26_drouotrenard.DataBase.LigneListAdapter;
import fr.utt.if26.projetif26_drouotrenard.DataBase.LigneViewModel;
import fr.utt.if26.projetif26_drouotrenard.DataBase.ModuleViewModel;
import fr.utt.if26.projetif26_drouotrenard.R;
import fr.utt.if26.projetif26_drouotrenard.RecyclerItemClickListener;

public class Parametrer3ListActivity extends AppCompatActivity implements View.OnClickListener {

    private int lastClicked = 0;
    private Button btnSupprimer;
    private Button btnEditer;
    private RecyclerView recyclerView;
    private LigneViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrer3_list);

        btnSupprimer = findViewById(R.id.parametrer3List_supprimeButton);
        btnEditer = findViewById(R.id.parametrer3List_editButton);

        model = new ViewModelProvider(this).get(LigneViewModel.class);

        final LigneListAdapter adapter = new LigneListAdapter(this);

        recyclerView = findViewById(R.id.parametrer3List_RecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        lastClicked = adapter.getLignes().get(position).getId();
                        for (int i = 0; i < recyclerView.getChildCount(); i++) {
                            View v = recyclerView.getChildAt(i);
                            v.setBackgroundColor(Color.TRANSPARENT);
                        }
                        view.setBackgroundColor(getResources().getColor(R.color.bestColor));
                    }
                })
        );

        model.getAllLignes().observe(this, new Observer<List<Ligne>>() {
            @Override
            public void onChanged(List<Ligne> lignes) {
                adapter.setLignes(lignes);
            }
        });

        btnSupprimer.setOnClickListener(this);
        btnEditer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.parametrer3List_supprimeButton:
                if(lastClicked != 0){
                    model.deleteById(lastClicked);
                    Toast.makeText(this, lastClicked+" a été supprimé !", Toast.LENGTH_SHORT).show();
                    lastClicked = 0;
                    for (int i = 0; i < recyclerView.getChildCount(); i++) {
                        View child = recyclerView.getChildAt(i);
                        child.setBackgroundColor(Color.TRANSPARENT);
                    }
                } else {
                    Toast.makeText(this, "Selectionner un module !", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.parametrer3List_editButton:
                Toast.makeText(this, "EDITION EN COURS DE DEV !", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

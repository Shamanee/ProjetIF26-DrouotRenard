package fr.utt.if26.projetif26_drouotrenard.Parametrer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import fr.utt.if26.projetif26_drouotrenard.DataBase.Parametre;
import fr.utt.if26.projetif26_drouotrenard.DataBase.ParametreListAdapter;
import fr.utt.if26.projetif26_drouotrenard.DataBase.ParametreViewModel;
import fr.utt.if26.projetif26_drouotrenard.R;
import fr.utt.if26.projetif26_drouotrenard.RecyclerItemClickListener;

public class Parametrer4ListActivity extends AppCompatActivity implements View.OnClickListener {

    private int lastClickedId = 0;
    private Parametre lastClickedParam;
    private Button btnSupprimer;
    private Button btnEditer;
    private RecyclerView recyclerView;
    private ParametreViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrer4_list);

        btnSupprimer = findViewById(R.id.parametrer4List_supprimeButton);
        btnEditer = findViewById(R.id.parametrer4List_editButton);

        model = new ViewModelProvider(this).get(ParametreViewModel.class);

        final ParametreListAdapter adapter = new ParametreListAdapter(this);

        recyclerView = findViewById(R.id.parametrer4List_RecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        lastClickedId = adapter.getParametres().get(position).getId();
                        lastClickedParam = adapter.getParametres().get(position);
                        for (int i = 0; i < recyclerView.getChildCount(); i++) {
                            View v = recyclerView.getChildAt(i);
                            v.setBackgroundColor(Color.TRANSPARENT);
                        }
                        view.setBackgroundColor(getResources().getColor(R.color.bestColor));
                    }
                })
        );

        model.getAllParametres().observe(this, new Observer<List<Parametre>>() {
            @Override
            public void onChanged(List<Parametre> lignes) {
                adapter.setParametres(lignes);
            }
        });

        btnSupprimer.setOnClickListener(this);
        btnEditer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.parametrer4List_supprimeButton:
                if(lastClickedId != 0){
                    model.deleteById(lastClickedId);
                    Toast.makeText(this, lastClickedId+" a été supprimé !", Toast.LENGTH_SHORT).show();
                    lastClickedId = 0;
                    for (int i = 0; i < recyclerView.getChildCount(); i++) {
                        View child = recyclerView.getChildAt(i);
                        child.setBackgroundColor(Color.TRANSPARENT);
                    }
                } else {
                    Toast.makeText(this, "Selectionner un module !", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.parametrer4List_editButton:
                if(lastClickedId != 0){
                    Intent intent = new Intent(this, Parametrer4Activity.class);
                    intent.putExtra("Value",lastClickedParam.getType());
                    intent.putExtra("edit", true);
                    intent.putExtra("id", lastClickedId);
                    startActivity(intent);
//                Toast.makeText(this, "EDITION EN COURS DE DEV !", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Selectionner un module !", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

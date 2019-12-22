package fr.utt.if26.projetif26_drouotrenard.Parametrer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import fr.utt.if26.projetif26_drouotrenard.DataBase.Ligne;
import fr.utt.if26.projetif26_drouotrenard.DataBase.LigneListAdapter;
import fr.utt.if26.projetif26_drouotrenard.DataBase.LigneViewModel;
import fr.utt.if26.projetif26_drouotrenard.R;

public class Parametrer2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrer2);

        Button btn = (Button) findViewById(R.id.parametrer2View_btn);
        btn.setOnClickListener(this);

//        RecyclerView recyclerView = findViewById(R.id.parametre2_recyclerView);
//
//        final LigneListAdapter adapter = new LigneListAdapter(this);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        LigneViewModel model = new ViewModelProvider(this).get(LigneViewModel.class);
        Spinner spinner = findViewById(R.id.parametrer2_spinner);

//        model.getAllLignes().observe(this, new Observer<List<Ligne>>() {
//            @Override
//            public void onChanged(List<Ligne> lignes) {
//                adapter.setLignes(lignes);
//            }
//        });

        ArrayList lignesList = new ArrayList<>();
        ArrayList lignesIdList = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, lignesList);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        model.getAllLignes().observe(this, new Observer<List<Ligne>>() {
            @Override
            public void onChanged(List<Ligne> lignes) {
                for (Ligne ligne : lignes) {
                    lignesList.add(ligne.getNumeroSerie());
                    lignesIdList.add(ligne.getId());
                }
                adapter.notifyDataSetChanged();
            }
        });

        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.parametrer2View_btn:
                Intent intent = new Intent(this, Parametrer3Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}

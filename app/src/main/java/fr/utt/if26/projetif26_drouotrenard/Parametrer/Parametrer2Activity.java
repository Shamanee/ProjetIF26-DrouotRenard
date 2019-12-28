package fr.utt.if26.projetif26_drouotrenard.Parametrer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.utt.if26.projetif26_drouotrenard.DataBase.Ligne;
import fr.utt.if26.projetif26_drouotrenard.DataBase.LigneViewModel;
import fr.utt.if26.projetif26_drouotrenard.DataBase.Module;
import fr.utt.if26.projetif26_drouotrenard.DataBase.ModuleViewModel;
import fr.utt.if26.projetif26_drouotrenard.R;

public class Parametrer2Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText input_name;
    private Spinner spinner;

    private int moduleId;
    private String moduleNom;
    private int moduleLigneId;
    private boolean moduleEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrer2);

        this.input_name = findViewById(R.id.parametrer2_editText_Name);
        this.spinner= findViewById(R.id.parametrer2_spinner);
        Button btn = (Button) findViewById(R.id.parametrer2View_liste);
        Button addButton = (Button) findViewById(R.id.parametrer2_add_module);

        Intent intent = getIntent();
        int moduleId = intent.getIntExtra("id", 0);
        String moduleNom = intent.getStringExtra("nom");
        int moduleLigneId = intent.getIntExtra("ligneId", 0);
        boolean moduleEdit = intent.getBooleanExtra("edit", false);

        this.moduleId = moduleId;
        this.moduleNom = moduleNom;
        this.moduleLigneId = moduleLigneId;
        this.moduleEdit = moduleEdit;

        if (moduleNom != null){
            this.input_name.setText(moduleNom);
        }

        btn.setOnClickListener(this);
        addButton.setOnClickListener(this);

        LigneViewModel model = new ViewModelProvider(this).get(LigneViewModel.class);

        ArrayList lignesList = new ArrayList<>();
        ArrayList lignesIdList = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, lignesList);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        model.getAllLignes().observe(this, new Observer<List<Ligne>>() {
            @Override
            public void onChanged(List<Ligne> lignes) {
                for (Ligne ligne : lignes) {
                    if (!lignesIdList.contains(ligne.getId())) {
                        lignesIdList.add(ligne.getId());
                        lignesList.add(ligne.getNumeroSerie());
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });

        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.parametrer2View_liste:
                Intent intent = new Intent(this, Parametrer2ListActivity.class);
                startActivity(intent);
                break;
            case R.id.parametrer2_add_module:
                if (!this.input_name.getText().toString().equals("")) {
                    ModuleViewModel moduleViewModel = new ModuleViewModel(getApplication());
                    if (!moduleEdit) {
                        Module module = new Module(this.input_name.getText().toString(), (int) spinner.getSelectedItemId() + 1);
                        moduleViewModel.insert(module);
                        Toast.makeText(this, "Ajout réussi !", Toast.LENGTH_SHORT).show();
                    } else {
                        moduleViewModel.updateById(moduleId, this.input_name.getText().toString(), (int) spinner.getSelectedItemId() + 1);
                        Toast.makeText(this, "Edition réussie !", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Veuillez remplir les champs", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}

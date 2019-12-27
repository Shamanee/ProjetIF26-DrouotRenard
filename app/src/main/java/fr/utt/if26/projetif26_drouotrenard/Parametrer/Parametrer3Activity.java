package fr.utt.if26.projetif26_drouotrenard.Parametrer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import fr.utt.if26.projetif26_drouotrenard.DataBase.Parametre;
import fr.utt.if26.projetif26_drouotrenard.DataBase.ParametreViewModel;
import fr.utt.if26.projetif26_drouotrenard.R;

public class Parametrer3Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText input_numero;
    private EditText input_obj;
    private EditText input_reel;
    private Spinner spinner;

    private int ligneId;
    private String ligneNumeroDeSerie;
    private String ligneObjectif;
    private String ligneReel;
    private int ligneParamId;
    private boolean ligneEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrer3);

        this.input_numero = findViewById(R.id.parametrer3View_editText_num);
        this.input_obj = findViewById(R.id.parametrer3View_editText_obj);
        this.input_reel = findViewById(R.id.parametrer3View_editText_reel);
        this.spinner = (Spinner) findViewById(R.id.parametrer3View_spinner_param);
        Button addButton = findViewById(R.id.parametre3View_btn_valider);
        Button addParamBtn = findViewById(R.id.paraemtrer3View_btn_vueListe);

        Intent intent = getIntent();
        int ligneId = intent.getIntExtra("id", 0);
        String ligneNumeroDeSerie = intent.getStringExtra("numeroDeSerie");
        String ligneObjectif = intent.getStringExtra("objectif");
        String ligneReel = intent.getStringExtra("reel");
        int ligneParamId = intent.getIntExtra("paramId", 0);
        boolean ligneEdit = intent.getBooleanExtra("edit", false);

        this.ligneId = ligneId;
        this.ligneEdit = ligneEdit;
        this.ligneObjectif = ligneObjectif;
        this.ligneReel = ligneReel;
        this.ligneParamId = ligneParamId;

        if (ligneNumeroDeSerie != null) {
            this.input_numero.setText(ligneNumeroDeSerie);
        }
        if (ligneObjectif != null) {
            this.input_obj.setText(ligneObjectif);
        }
        if (ligneReel != null) {
            this.input_reel.setText(ligneReel);
        }

        addButton.setOnClickListener(this);
        addParamBtn.setOnClickListener(this);

        ParametreViewModel model = new ViewModelProvider(this).get(ParametreViewModel.class);

        ArrayList parametresList = new ArrayList<>();
        ArrayList parametresIdList = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, parametresList);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        model.getAllParametres().observe(this, new Observer<List<Parametre>>() {
            @Override
            public void onChanged(List<Parametre> parametres) {
                for (Parametre parametre : parametres) {
                    parametresList.add(parametre.getType());
                    parametresIdList.add(parametre.getId());
                }
//                if (ligneParamId != 0) {
//                    int spinnerPosition = adapter.getPosition(ligneNumeroDeSerie);
//                    spinner.setSelection(ligneParamId);
//                }
                adapter.notifyDataSetChanged();
            }
        });

        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.parametre3View_btn_valider:
                if (!this.input_numero.getText().toString().equals("")) {
                    LigneViewModel ligneViewModel = new LigneViewModel(getApplication());
                    if (!ligneEdit) {
                        Ligne ligne = new Ligne(this.input_numero.getText().toString(), this.input_obj.getText().toString(), this.input_reel.getText().toString(), (int) spinner.getSelectedItemId() + 1);
                        ligneViewModel.insert(ligne);
                        Toast.makeText(this, "Ajout réussi !", Toast.LENGTH_SHORT).show();
                    } else {
                        ligneViewModel.updateById(ligneId, this.input_numero.getText().toString(), this.input_obj.getText().toString(), this.input_reel.getText().toString(), (int) spinner.getSelectedItemId() + 1);
                        Toast.makeText(this, "Edition réussie !", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Veuillez remplir les champs", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.paraemtrer3View_btn_vueListe:
                Intent intent = new Intent(this, Parametrer3ListActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}

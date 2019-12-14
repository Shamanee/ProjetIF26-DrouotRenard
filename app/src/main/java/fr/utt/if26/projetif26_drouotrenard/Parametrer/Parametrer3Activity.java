package fr.utt.if26.projetif26_drouotrenard.Parametrer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import fr.utt.if26.projetif26_drouotrenard.DataBase.AppDatabase;
import fr.utt.if26.projetif26_drouotrenard.DataBase.Ligne;
import fr.utt.if26.projetif26_drouotrenard.DataBase.LigneViewModel;
import fr.utt.if26.projetif26_drouotrenard.DataBase.Module;
import fr.utt.if26.projetif26_drouotrenard.DataBase.ModuleViewModel;
import fr.utt.if26.projetif26_drouotrenard.DataBase.Parametre;
import fr.utt.if26.projetif26_drouotrenard.DataBase.ParametreViewModel;
import fr.utt.if26.projetif26_drouotrenard.R;

public class Parametrer3Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText input_numero;
    private EditText input_obj;
    private EditText input_reel;


    private ParametreViewModel model;

    ArrayAdapter<Parametre> adapter;
//    LiveData<List<Parametre>> parametreList = AppDatabase.getDatabase(this).parametreDao().getAll();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrer3);

        this.input_numero = findViewById(R.id.parametrer3View_editText_num);
        this.input_obj = findViewById(R.id.parametrer3View_editText_obj);
        this.input_reel = findViewById(R.id.parametrer3View_editText_reel);
        Spinner spinner = (Spinner) findViewById(R.id.parametrer3View_spinner_param);
        Button addButton = findViewById(R.id.parametre3View_btn_valider);

        addButton.setOnClickListener(this);

//        List<Parametre> parametreList = AppDatabase.getDatabase(this).parametreDao().getAllB();
//        this.adapter = new ArrayAdapter<Parametre>(Parametrer3Activity.this, R.layout.support_simple_spinner_dropdown_item, parametreList);
//        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        adapter.notifyDataSetChanged();

//        LiveData<List<Parametre>> parametreList = AppDatabase.getDatabase(this).parametreDao().getAll();
//        this.adapter = new ArrayAdapter<Parametre>(Parametrer3Activity.this, R.layout.support_simple_spinner_dropdown_item, (List<Parametre>) parametreList);
//        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.parametre3View_btn_valider) {
            LigneViewModel ligneViewModel = new LigneViewModel(getApplication());
            Ligne ligne = new Ligne(this.input_numero.getText().toString(), this.input_obj.getText().toString(), this.input_reel.getText().toString());
            ligneViewModel.insert(ligne);
            Toast.makeText(this, "Ajout réussi !", Toast.LENGTH_SHORT).show();
        }
    }
}

package fr.utt.if26.projetif26_drouotrenard.Parametrer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fr.utt.if26.projetif26_drouotrenard.DataBase.Parametre;
import fr.utt.if26.projetif26_drouotrenard.DataBase.ParametreViewModel;
import fr.utt.if26.projetif26_drouotrenard.R;

public class Parametrer4Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText input_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrer4);

        this.input_type = findViewById(R.id.parametrer4_editText_type);
        Button button = findViewById(R.id.parametrer4_btn_valider);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.parametrer4_btn_valider) {
            if (!this.input_type.getText().toString().equals("")) {
                ParametreViewModel parametreViewModel = new ParametreViewModel(getApplication());
                Parametre parametre = new Parametre(this.input_type.getText().toString());
                parametreViewModel.insert(parametre);
                Toast.makeText(this, "Ajout réussi !", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Veuillez remplir les champs", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

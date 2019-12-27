package fr.utt.if26.projetif26_drouotrenard.Parametrer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fr.utt.if26.projetif26_drouotrenard.DataBase.Parametre;
import fr.utt.if26.projetif26_drouotrenard.DataBase.ParametreViewModel;
import fr.utt.if26.projetif26_drouotrenard.R;

public class Parametrer4Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText input_type;

    private int paramId;
    private boolean paramEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrer4);

        this.input_type = findViewById(R.id.parametrer4_editText_type);
        Button button = findViewById(R.id.parametrer4_btn_valider);
        Button buttonList = findViewById(R.id.parametrer4_btn_vueListe);

        Intent intent = getIntent();
        int paramId = intent.getIntExtra("id", 0);
        String paramValue = intent.getStringExtra("Value");
        boolean paramEdit = intent.getBooleanExtra("edit", false);

        this.paramId = paramId;
        this.paramEdit = paramEdit;

        if (paramValue != null){
            this.input_type.setText(paramValue);
        }

        button.setOnClickListener(this);
        buttonList.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case  R.id.parametrer4_btn_valider:

            if (!this.input_type.getText().toString().equals("")) {
                ParametreViewModel parametreViewModel = new ParametreViewModel(getApplication());
                if (!paramEdit) {
                    Parametre parametre = new Parametre(this.input_type.getText().toString());
                    parametreViewModel.insert(parametre);
                    Toast.makeText(this, "Ajout réussi !", Toast.LENGTH_SHORT).show();
                } else {
                   parametreViewModel.updateById(paramId, this.input_type.getText().toString());
                   Toast.makeText(this, "Edition réussie !", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Veuillez remplir les champs", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.parametrer4_btn_vueListe:
                Intent intent = new Intent(this, Parametrer4ListActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}

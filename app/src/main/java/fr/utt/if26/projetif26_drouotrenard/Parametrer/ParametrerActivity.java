package fr.utt.if26.projetif26_drouotrenard.Parametrer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.utt.if26.projetif26_drouotrenard.R;

public class ParametrerActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrer);

        Button btn_addModule = (Button) findViewById(R.id.parametrerView_addModule);
        Button btn_addLigne = (Button) findViewById(R.id.parametrerView_addLigne);
        Button btn_addParam = (Button) findViewById(R.id.parametrerView_addParam);
        btn_addModule.setOnClickListener(this);
        btn_addLigne.setOnClickListener(this);
        btn_addParam.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.parametrerView_addModule:
                Intent intent_Param2 = new Intent(this, Parametrer2Activity.class);
                startActivity(intent_Param2);
                break;
            case R.id.parametrerView_addLigne:
                Intent intent_Param3 = new Intent(this, Parametrer3Activity.class);
                startActivity(intent_Param3);
                break;
            case R.id.parametrerView_addParam:
                Intent intent_Param4 = new Intent(this, Parametrer4Activity.class);
                startActivity(intent_Param4);
                break;
            default:
                break;
        }
    }
}

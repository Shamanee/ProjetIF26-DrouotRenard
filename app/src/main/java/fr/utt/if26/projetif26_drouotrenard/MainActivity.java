package fr.utt.if26.projetif26_drouotrenard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.utt.if26.projetif26_drouotrenard.Parametrer.ParametrerActivity;
import fr.utt.if26.projetif26_drouotrenard.Stocker.StockerActivity;
import fr.utt.if26.projetif26_drouotrenard.Tracabilite.TracabiliteActivity;
import fr.utt.if26.projetif26_drouotrenard.Utiliser.UtiliserActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView title = findViewById(R.id.main_tv);
        title.setTextSize(38f);
        title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        Button btn_utiliser = (Button) findViewById(R.id.main_btn_1);
        btn_utiliser.setOnClickListener(this);

        Button btn_stocker = (Button) findViewById(R.id.main_btn_2);
        btn_stocker.setOnClickListener(this);

        Button btn_paramaetrer = (Button) findViewById(R.id.main_btn_3);
        btn_paramaetrer.setOnClickListener(this);

        Button btn_tracabilite = (Button) findViewById(R.id.main_btn_4);
        btn_tracabilite.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn_1:
                Intent intent_utiliser = new Intent(this, UtiliserActivity.class);
                startActivity(intent_utiliser);
                break;
            case R.id.main_btn_2:
                Intent intent_stocker = new Intent(this, StockerActivity.class);
                startActivity(intent_stocker);
                break;
            case R.id.main_btn_3:
                Intent intent_parametrer = new Intent(this, ParametrerActivity.class);
                startActivity(intent_parametrer);
                break;
            case R.id.main_btn_4:
                Intent intent_tracabilite = new Intent(this, TracabiliteActivity.class);
                startActivity(intent_tracabilite);
                break;
            default:
                break;
        }
    }
}

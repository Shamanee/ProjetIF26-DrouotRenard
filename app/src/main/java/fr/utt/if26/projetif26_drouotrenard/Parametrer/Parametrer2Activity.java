package fr.utt.if26.projetif26_drouotrenard.Parametrer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.utt.if26.projetif26_drouotrenard.R;

public class Parametrer2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrer2);

        Button btn = (Button) findViewById(R.id.parametrer2View_btn);
        btn.setOnClickListener(this);
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

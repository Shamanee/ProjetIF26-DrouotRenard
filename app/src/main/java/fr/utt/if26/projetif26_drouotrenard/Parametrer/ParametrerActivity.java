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

        Button btn = (Button) findViewById(R.id.parametrerView_button);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.parametrerView_button:
                Intent intent = new Intent(this, Parametrer2Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}

package fr.utt.if26.projetif26_drouotrenard.Tracabilite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.utt.if26.projetif26_drouotrenard.R;

public class TracabiliteActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracabilite);

        Button btn = (Button) findViewById(R.id.tracabiliteView_creer);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tracabiliteView_creer:
                Intent intent = new Intent(this, Tracabilite2Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}

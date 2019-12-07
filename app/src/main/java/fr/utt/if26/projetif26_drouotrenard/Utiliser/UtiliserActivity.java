package fr.utt.if26.projetif26_drouotrenard.Utiliser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.utt.if26.projetif26_drouotrenard.R;

public class UtiliserActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utiliser);

        Button btn = (Button) findViewById(R.id.utiliserView_creer);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.utiliserView_creer:
                Intent intent = new Intent(this, Utiliser2Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}

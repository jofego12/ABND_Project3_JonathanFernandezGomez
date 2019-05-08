package com.example.android.abnd_project3_jonathanfernandezgomez;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void calculateScore() {
        RadioButton vegeta = findViewById(R.id.vegeta);
        if (vegeta.isChecked()) {
            score++;
        }

        EditText attackName = findViewById(R.id.attack_editText);
        String attackEntry = attackName.getText().toString().trim().toLowerCase();
        if (attackEntry.equals("kamehameha")) {
            score++;
        }

        CheckBox sonGohan = findViewById(R.id.gohan_checkBox);
        CheckBox sonGoku = findViewById(R.id.goku_checkBox);
        CheckBox videl = findViewById(R.id.videl_checkBox);
        CheckBox trunks = findViewById(R.id.trunks_checkBox);
        CheckBox yamcha = findViewById(R.id.yamcha_checkBox);
        CheckBox popo = findViewById(R.id.popo_checkBox);
        CheckBox krillin = findViewById(R.id.krillin_checkBox);
        if ((videl.isChecked() && yamcha.isChecked() && krillin.isChecked()) && !(sonGohan.isChecked() || sonGoku.isChecked() || trunks.isChecked() || popo.isChecked())) {
            score = score + 3;
        } else if ((videl.isChecked() && yamcha.isChecked() || krillin.isChecked() && videl.isChecked() || krillin.isChecked() && yamcha.isChecked()) && !(sonGohan.isChecked() || sonGoku.isChecked() || trunks.isChecked() || popo.isChecked())) {
            score = score + 2;
        } else if ((videl.isChecked() || krillin.isChecked() || yamcha.isChecked()) && !(sonGohan.isChecked() || sonGoku.isChecked() || trunks.isChecked() || popo.isChecked())) {
            score++;
        }

        EditText authorName = findViewById(R.id.author_editText);
        String authorEntry = authorName.getText().toString().trim().toLowerCase();
        if (authorEntry.equals("akira toriyama")) {
            score++;
        }
    }

    public void displayScore(View view) {
        score = 0;
        calculateScore();
        if (score == 0) {
            Toast.makeText(this, "Try it harder the next time, INSECT!", Toast.LENGTH_LONG).show();
        } else if (score <= 3) {
            Toast.makeText(this, "Keep training and you'll defeat Yamcha (maybe).", Toast.LENGTH_LONG).show();
        } else if (score <= 5) {
            Toast.makeText(this, "Let's protect the Earth together!", Toast.LENGTH_LONG).show();
        } else if (score == 6) {
            Toast.makeText(this, "You're an ALL MIGHTY SUPER SAIYAN!", Toast.LENGTH_LONG).show();
        }
    }
}
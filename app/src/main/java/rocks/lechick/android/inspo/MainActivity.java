package rocks.lechick.android.inspo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    int rg1checked;
    int rg2checked;
    int rg3checked;
    int correct = 5;
    int score;
    String customerName;
    String createMessage;
    String year_answered;
    String correct_year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Summarise(View view) {
        EditText name = (EditText) findViewById(R.id.name);
        customerName = name.getText().toString();
        EditText year_entered = (EditText) findViewById(R.id.year_answer);
        year_answered = year_entered.getText().toString();
        correct_year = getString(R.string.correct_year);
        calculateScore();
        createMessage();
        Toast.makeText(getApplicationContext(), createMessage, Toast.LENGTH_LONG).show();
        score = 0;
    }

    public void calculateScore() {
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.rg1);
        rg1checked = rg1.getCheckedRadioButtonId();
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.rg2);
        rg2checked = rg2.getCheckedRadioButtonId();
        RadioGroup rg3 = (RadioGroup) findViewById(R.id.rg3);
        rg3checked = rg3.getCheckedRadioButtonId();
        CheckBox correct31 = (CheckBox) findViewById(R.id.correct31);
        CheckBox correct32 = (CheckBox) findViewById(R.id.correct32);
        CheckBox incorrect31 = (CheckBox) findViewById(R.id.incorrect31);
        CheckBox incorrect32 = (CheckBox) findViewById(R.id.incorrect32);
        CheckBox incorrect33 = (CheckBox) findViewById(R.id.incorrect33);



        if (correct_year.equals(year_answered)) {
            score = score + correct;
        }

        if (rg1checked == R.id.correct11) {
            score = score + correct;
        }

        if (rg2checked == R.id.correct21) {
            score = score + correct;
        }

        if (correct31.isChecked() && correct32.isChecked()) {
            score = score + correct;
        }

        if (incorrect31.isChecked() || incorrect32.isChecked() || incorrect33.isChecked()){
            score = score - correct;
        }

        if (rg3checked == R.id.correct41) {
            score = score + correct;
        }
    }

    public void createMessage() {
        if (score == 25) {
            createMessage = "Hey " + customerName + ", you've scored " + score + " today! \nWohoo! This is the top score!";
        } else {
            createMessage = "Hey " + customerName + ", you've scored " + score + " out of 25 today. Would you like to try again?";
        }
        score = 0;
    }
}

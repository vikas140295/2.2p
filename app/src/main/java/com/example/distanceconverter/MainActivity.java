package com.example.distanceconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Conversion conversion = new Conversion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initislseUI(savedInstanceState);
    }

    void initislseUI(Bundle savedInstanceState) {
        Button convert = findViewById(R.id.iConvert);

        convert.setOnClickListener(clickListener);
        restoreUI(savedInstanceState);
        convertValue();
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            convertValue();
        }
    };

    private void convertValue() {
        EditText miles = findViewById(R.id.iMiles);
        EditText inches = findViewById(R.id.iInches);
        EditText feet = findViewById(R.id.iFoot);
        CheckBox check = findViewById(R.id.checkBox);

        String m = miles.getText().toString();
        String i = inches.getText().toString();
        String f = feet.getText().toString();
        String answerStr;
        TextView displayResult = findViewById(R.id.iResult);

        String result = conversion.distanceConverter(m,i,f);

        if(check.isChecked())
        {
            double answer = Double.valueOf(result);
            answer = answer/100.0;
            answerStr=String.valueOf(answer);
            displayResult.setText(answerStr + "Meters");

        }
        else
        {
            displayResult.setText(result + "CentiMeter");
        }

    }





    protected void onSaveInstanceState(Bundle state) {
        EditText miles= findViewById(R.id.iMiles);
        String sMiles = miles.getText().toString();
        state.putString("CELCIUS", sMiles);
        super.onSaveInstanceState(state);
    }

    // TODO #6b write a function to restore state here.


    private void restoreUI(Bundle state) {

        if (state == null){return;}
        String sMiles = state.getString("Miles");
        EditText mil = findViewById(R.id.iMiles);
        mil.setText(sMiles);

            String sInches = state.getString("Inches");
            EditText inch = findViewById(R.id.iInches);
            inch.setText(sInches);

            String sfeet = state.getString("Feet");
            EditText foot = findViewById(R.id.iFoot);
            foot.setText(sfeet);

    }


}


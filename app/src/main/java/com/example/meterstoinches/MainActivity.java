package com.example.meterstoinches;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//1m = 39.3701 inches

    private EditText enterMeters;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterMeters = (EditText) findViewById(R.id.metersEditText);

        convertButton = (Button) findViewById(R.id.convertId);
        convertButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //conversion logic
                double multiplier = 39.37;
                double end_Result = 0.0;

                if (enterMeters.getText().toString().equals("")){
                    resultTextView.setText(R.string.error_message);
                    resultTextView.setTextColor(Color.RED);
                }else{
                    double meterValue = Double.parseDouble(enterMeters.getText().toString());
                    //the entered value is incompatible with the string value, therefore must be parsed as a double
                    end_Result = meterValue*multiplier;
                    resultTextView.setTextColor(Color.BLUE);
                    resultTextView.setText(String.format("%.2f", end_Result) + " inches");

                }
            }
        });
        resultTextView = (TextView) findViewById(R.id.resultId);
    }
}
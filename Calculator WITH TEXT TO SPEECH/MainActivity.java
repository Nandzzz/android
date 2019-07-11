package com.kc.calculatorp11;

import android.content.pm.ActivityInfo;
        import android.os.Bundle;
        import android.os.Handler;
        import android.speech.tts.TextToSpeech;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNumber;
    Button btnSquare, btnSquareRoot, btnCube;
    TextView tvAnswer;

    TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(orientation);

        etNumber = (EditText) findViewById(R.id.etNumber);
        btnSquare = (Button) findViewById(R.id.btnSquare);
        btnSquareRoot = (Button) findViewById(R.id.btnSquareRoot);
        btnCube = (Button) findViewById(R.id.btnCube);
        tvAnswer = (TextView) findViewById(R.id.tvAnswer);

        btnSquare.setOnClickListener(this);
        btnSquareRoot.setOnClickListener(this);
        btnCube.setOnClickListener(this);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });
    }


    @Override
    public void onClick(View v) {

        if (etNumber.getText().toString().length() == 0){
            Toast.makeText(this, "Enter a Number", Toast.LENGTH_SHORT).show();
            etNumber.requestFocus();
            return;
        }

        double number;

        switch(v.getId()) {

            case R.id.btnSquare:
                number = Double.parseDouble(etNumber.getText().toString());
                double square  = number * number;
                tvAnswer.setText("Square of " + number + " is: " + square);
                break;

            case R.id.btnSquareRoot:
                number = Double.parseDouble(etNumber.getText().toString());
                double squareRoot  = Math.sqrt(number);
                tvAnswer.setText("Square root of " + number + " is: " + squareRoot);
                break;

            case R.id.btnCube:
                number = Double.parseDouble(etNumber.getText().toString());
                double cube  = number * number * number;
                tvAnswer.setText("Cube of " + number + " is: " + cube);
                break;
        }

        String toSpeak = tvAnswer.getText().toString();
        Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
        textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }

}

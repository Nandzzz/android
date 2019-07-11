package com.kc.phoneinfotalker;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnPhoneModelAndManufacturer;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPhoneModelAndManufacturer = (Button) findViewById(R.id.btnPhoneModelAndManufacturer);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });


        btnPhoneModelAndManufacturer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String model = Build.MODEL;
                String name = Build.MANUFACTURER;
                String answer = "Model: " + model + "\n " + "Name: " + name;
                Toast.makeText(getApplicationContext(),answer , Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_SHORT).show();
                textToSpeech.speak(answer, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

    }

}

package com.kc.tutorialapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ChapterActivity extends AppCompatActivity {

    TextView tvChapterContent;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        tvChapterContent = (TextView) findViewById(R.id.tvChapterContent);

        position = getIntent().getIntExtra("position", 0);

        try {

            String fileName = "Chapter " + (position + 1) + ".txt";
            InputStreamReader isr = new InputStreamReader(getAssets().open(fileName));
            BufferedReader reader = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String line;
            while ( (line =  reader.readLine() ) != null) {
                sb.append(line); // process line
            }
            reader.close();
            String text = sb.toString();

            tvChapterContent.setText(text);
        }
        catch (Exception e) {
            Log.e("error", e.getMessage());
        }

    }
}

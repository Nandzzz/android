package com.kc.alarmsetting;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etHourMinute;
    Button btnSetAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHourMinute = (EditText) findViewById(R.id.etHourMinute);
        btnSetAlarm = (Button) findViewById(R.id.btnSetAlarm);

        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] hm = etHourMinute.getText().toString().split(":");
                int hour = Integer.parseInt(hm[0]);
                int minute = Integer.parseInt(hm[1]);

                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
                intent.putExtra(AlarmClock.EXTRA_MINUTES, minute);

//                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
//                }
            }
        });
    }
}

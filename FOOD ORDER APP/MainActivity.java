package com.kc.foodorderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSelectFood, btnOrder;
    TextView tvFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelectFood = (Button) findViewById(R.id.btnSelectFood);
        btnOrder = (Button) findViewById(R.id.btnOrder);
        tvFood = (TextView) findViewById(R.id.tvFood);

        btnSelectFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, FoodSelectActivity.class);
                startActivityForResult(i, 1234);
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Order placed successfully", Toast.LENGTH_SHORT)
                        .show();
            }
        });
        
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == 1234) {

                String foodName = data.getStringExtra("FoodName");
                tvFood.setText(foodName);
            }
        }

    }












}

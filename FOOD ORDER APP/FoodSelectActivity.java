package com.kc.foodorderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FoodSelectActivity extends AppCompatActivity {

    RadioGroup rgFoodItems;
//    RadioButton rbDosa, rbBurger;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_select);

        rgFoodItems = (RadioGroup) findViewById(R.id.rgFoodItems);
//        rbDosa = (RadioButton) findViewById(R.id.rbDosa);
//        rbBurger = (RadioButton) findViewById(R.id.rbBurger);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int rbId = rgFoodItems.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(rbId);

                String foodItem = rb.getText().toString();

                Intent i = new Intent();
                i.putExtra("FoodName", foodItem);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}

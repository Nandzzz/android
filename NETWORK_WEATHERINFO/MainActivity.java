package com.kc.weatherinfo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText etMovieName;
    Button btnSearch;
    TextView tvSearchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMovieName = (EditText) findViewById(R.id.etMoveiName);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        tvSearchResults = (TextView) findViewById(R.id.tvSearchResults);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mn = etMovieName.getText().toString();
                if(mn.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Location Name empty", Toast.LENGTH_LONG).show();
                }
                else {
                    tvSearchResults.setText("");
                    Task1 t1 = new Task1();
                    t1.execute("http://api.openweathermap.org/data/2.5/weather?units=metric&q="
                            + mn + "&appid=" + "c6e315d09197cec231495138183954bd" );
                }
            }
        });
    }

    class Task1 extends AsyncTask<String, Void, Double> {

        double temperature;
        @Override
        protected Double doInBackground(String... params) {
            String json = "";
            String line = "";
            String searchResults = "";

            try {
                URL url = new URL(params[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.connect();
                InputStream is = con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                while((line = br.readLine()) != null){
                    json += line + "\n";
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(json != null) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONObject quote = jsonObject.getJSONObject("main");
                    temperature = quote.getDouble("temp");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            return temperature;
        }

        @Override
        protected void onPostExecute(Double s) {
            super.onPostExecute(s);
            tvSearchResults.setText(" " + s);
        }
    }
}

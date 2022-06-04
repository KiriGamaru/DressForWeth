package com.example.dressforweth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {



//интерфэйс
    private TextView tvWeather;
    private EditText edCity;
    private Button btnSettings;

    private Switch swGender;

    private ListView list_of_clothes;
    private Button btnNotes;

//погода
    public double temp;
    public String rain;
    public double wind;


    //create data
    ArrayList<Clothes> clothesList = new ArrayList<>();
    MyAdapter myAdapter;

boolean test = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvWeather = findViewById(R.id.tvWeather);
        edCity = findViewById(R.id.edZametka);
        btnSettings = findViewById(R.id.btnSettings);

        swGender = findViewById(R.id.swGender);
        swGender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    test = true;
                }
                else{
                    test = false;
                }

            }
        });


        list_of_clothes = findViewById(R.id.list_of_clothes);

        myAdapter = new MyAdapter(this, R.layout.list_item, clothesList);

        btnNotes = findViewById(R.id.btnNotes);


        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edCity.getText().toString().trim().equals(""))
                    Toast.makeText(MainActivity.this, R.string.no_user_input, Toast.LENGTH_LONG).show();
                else{
                    String city = edCity.getText().toString();
                    String key = "e6507b21733348adaf3105220220106";
                    String url = "https://api.weatherapi.com/v1/current.json?key="+ key + "&q=" + city + "&lang=ru";
                    new GetURLData().execute(url);
                }



            }
        });
    }

    public void onClickZametki(View view) {
        Intent i = new Intent(MainActivity.this, ZametkiActivity.class);
        startActivity(i);
    }


    private class GetURLData extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
            tvWeather.setText("Ожидайте...");
        }

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while((line = reader.readLine()) !=null )
                    buffer.append(line).append("\n");

                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(connection != null)
                    connection.disconnect();

                try {
                    if (reader != null)
                        reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                JSONObject jsonObject = new JSONObject(result);
                temp = jsonObject.getJSONObject("current").getDouble("temp_c");
                rain = jsonObject.getJSONObject("current").getJSONObject("condition").getString("text");
                wind = jsonObject.getJSONObject("current").getDouble("wind_mph");

                tvWeather.setText("Сейчас на улице: " + temp +" ℃ \n" +
                         rain + "\n" +
                        "ветер " + wind + " м/с");

                if ( test == true) {
                    new Clothes().showClothesM(temp, rain, wind, clothesList);
                }
                else {
                    new Clothes().showClothesF(temp, rain, wind, clothesList);
                }
                list_of_clothes.setAdapter(myAdapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }



    }


}
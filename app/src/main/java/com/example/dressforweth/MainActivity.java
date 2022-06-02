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

//______________________________________________________________________________________________________
    //create data
    ArrayList<Clothes> clothesList = new ArrayList<>();
    MyAdapter myAdapter;

    Clothes botinki = new Clothes(R.drawable.bot, "ботинки","в них ногам точно будет тепло");
    Clothes futbolka = new Clothes(R.drawable.futbolka, "футблока","это футболка");
    Clothes girlFutbolka = new Clothes(R.drawable.girlfutbolka, "футблока","это футболка");
    Clothes girlHat = new Clothes(R.drawable.girlhat,"головной убор","защитит от солнца");
    Clothes girlMaika = new Clothes(R.drawable.girlmaika,"майка","это майка");
    Clothes hat = new Clothes(R.drawable.hat,"головной убор","защитит от солнца");
    Clothes ked = new Clothes(R.drawable.ked,"кеды","это кеды");
    Clothes kofta = new Clothes(R.drawable.kofta,"кофта","это кофта");
    Clothes kros = new Clothes(R.drawable.kros,"кросовки","это кросовки");
    Clothes kurtka = new Clothes(R.drawable.kurtka,"куртка","это куртка");
    Clothes maika = new Clothes(R.drawable.maika,"майка","это майка");
    Clothes pants = new Clothes(R.drawable.pants,"штаны","это штаны");
    Clothes platie = new Clothes(R.drawable.platie,"платье","это платье");
    Clothes puhovik = new Clothes(R.drawable.puhovik,"пуховик","это пуховик");
    Clothes rubashka = new Clothes(R.drawable.rubashka,"рубашка","это рубашка");
    Clothes sandals = new Clothes(R.drawable.sandals,"сандали","носить только с носками");
    Clothes shapka = new Clothes(R.drawable.shapka,"шапка","чтоб голова не мёрзла");
    Clothes shorts = new Clothes(R.drawable.shorts,"шорты","это шорты");
    Clothes vetrovka = new Clothes(R.drawable.vetrovka,"ветровка","защищает от ветра");
    Clothes yubka = new Clothes(R.drawable.yubka,"юбка","это юбка");
    Clothes zontik = new Clothes(R.drawable.zontik,"зонтик","это зонтик");

//______________________________________________________________________________________________________

    public void lookClothesM(double t, String r, double w){
        clothesList.clear();
        //жара
        if (t > 20 & r.equals("Солнечно") & w < 7) {
            clothesList.add(hat);
            clothesList.add(maika);
            clothesList.add(shorts);
            clothesList.add(sandals);
        }

        //жарковато
        if (t > 20 & !r.equals("Солнечно") & !r.equals("Дождь") & w < 7){
            clothesList.add(futbolka);
            clothesList.add(pants);
            clothesList.add(kros);
        }

        //жарковато, но ветер
        if (t > 20 & !r.equals("Солнечно") & !r.equals("Дождь") & w > 7){
            clothesList.add(futbolka);
            clothesList.add(vetrovka);
            clothesList.add(pants);
            clothesList.add(kros);
        }


        //дождь и жарковато
        if (t > 20 & !r.equals("Солнечно") & !r.equals("Дождь") & w < 7){
            clothesList.add(zontik);
            clothesList.add(rubashka);
            clothesList.add(pants);
            clothesList.add(kros);
        }


        //тёпленько
        if(t >= 10 & t <= 20 & !r.equals("Дождь") & w < 7){
            clothesList.add(kofta);
            clothesList.add(pants);
            clothesList.add(kros);
        }

        //дождь и тёпленько
        if(t >= 10 & t <= 20 & r.equals("Дождь") & w < 7){
            clothesList.add(zontik);
            clothesList.add(kofta);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        //тёпленько, но ветер
        if(t >= 10 & t <= 20 & r.equals("Дождь") & w < 7){
            clothesList.add(zontik);
            clothesList.add(kofta);
            clothesList.add(vetrovka);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        //по осеннему
        if (t <10 & t > -15)
        {
            clothesList.add(shapka);
            clothesList.add(futbolka);
            clothesList.add(kurtka);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        //зима
        if (t < -15 )
        {
            clothesList.add(shapka);
            clothesList.add(rubashka);
            clothesList.add(puhovik);
            clothesList.add(pants);
            clothesList.add(botinki);
        }

        list_of_clothes.setAdapter(myAdapter);
    }

    public void lookClothesF(double t, String r, double w){
        clothesList.clear();

        //жара
        if (t > 20 & r.equals("Солнечно") & w < 7) {
            clothesList.add(girlHat);
            clothesList.add(platie);
            clothesList.add(sandals);
        }

        //жарковато
        if (t > 20 & !r.equals("Солнечно") & !r.equals("Дождь") & w < 7){
            clothesList.add(girlMaika);
            clothesList.add(yubka);
            clothesList.add(kros);
        }

        //жарковато, но ветер
        if (t > 20 & !r.equals("Солнечно") & !r.equals("Дождь") & w > 7){
            clothesList.add(girlFutbolka);
            clothesList.add(vetrovka);
            clothesList.add(pants);
            clothesList.add(kros);
        }

        //дождь и жарковато
        if (t > 20 & !r.equals("Солнечно") & !r.equals("Дождь") & w < 7){
            clothesList.add(zontik);
            clothesList.add(girlFutbolka);
            clothesList.add(pants);
            clothesList.add(kros);
        }


        //тёпленько
        if(t >= 10 & t <= 20 & !r.equals("Дождь") & w < 7){
            clothesList.add(kofta);
            clothesList.add(pants);
            clothesList.add(kros);
        }

        //дождь и тёпленько
        if(t >= 10 & t <= 20 & r.equals("Дождь") & w < 7){
            clothesList.add(zontik);
            clothesList.add(kofta);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        //тёпленько, но ветер
        if(t >= 10 & t <= 20 & r.equals("Дождь") & w > 7){
            clothesList.add(zontik);
            clothesList.add(kofta);
            clothesList.add(vetrovka);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        //по осеннему
        if (t <10 & t > -15)
        {
            clothesList.add(shapka);
            clothesList.add(girlFutbolka);
            clothesList.add(kurtka);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        //зима
        if (t <-15 )
        {
            clothesList.add(shapka);
            clothesList.add(rubashka);
            clothesList.add(puhovik);
            clothesList.add(pants);
            clothesList.add(botinki);
        }

        list_of_clothes.setAdapter(myAdapter);
    }


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
                    lookClothesF(temp,rain,wind);
                }
                else{
                    lookClothesM(temp,rain,wind);
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



            } catch (JSONException e) {
                e.printStackTrace();
            }

        }



    }


}
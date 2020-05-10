package com.example.sehirtanitmakonya42;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActiviteKonya extends AppCompatActivity {
    GridView Grd_1;
    KonyaAdaptorAlihan Konya;
    Http_Bagla Bagla;
    ProgressDialog progressDialog;
    private String URL="https://raw.githubusercontent.com/Zrest/Eserler/master/eserler.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Grd_1=(GridView)findViewById(R.id.gridView1);
        new getEserler().execute();
    }
    private  class getEserler extends AsyncTask<Void,Void,Void>{
        ArrayList<Eser> Eserler =new ArrayList<>();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActiviteKonya.this);
            progressDialog.setMessage("Yükleniyor, Biraz Bekleyin....");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Konya = new KonyaAdaptorAlihan(MainActiviteKonya.this, Eserler);
            Grd_1.setAdapter(Konya);
            if (progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
        @Override
        protected Void doInBackground(Void... voids) {
            Bagla = new Http_Bagla();
            String JSON_String = Bagla.ServisAra(URL);
            Log.d("JSON_KarsıTepki",JSON_String);
            if (JSON_String != null){
                try {
                    JSONObject JSON_nesne = new JSONObject(JSON_String);
                    JSONArray eserler = JSON_nesne.getJSONArray("eserler");
                    for (int i=0 ; i<eserler.length() ; i++){
                        JSONObject eser = eserler.getJSONObject(i);
                        int id = eser.getInt("id");
                        String eser_ad = eser.getString("Eser_ad");
                        String eser_tarih = eser.getString("Eser_tarih");
                        String eser_aciklama = eser.getString("Eser_aciklama");
                        String eser_resim = eser.getString("Eser_resim");
                        Eser esr = new Eser(id, eser_ad, eser_tarih, eser_aciklama, eser_resim);
                        Eserler.add(esr);
                    }
                } catch (JSONException e) { }
            }else{
                Log.d("JSON_KarsıTepki","Opss Sayfa Kaynağında Eksiklik Var!!..");
            }
            return  null;
        }
    }
}

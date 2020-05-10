package com.example.sehirtanitmakonya42;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http_Bagla {
    public Http_Bagla(){
    }
    public String ServisAra(String adres){
        String Karsı_Tepki = null;
        try{ URL url = new URL(adres);
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");
                InputStream Gir = new BufferedInputStream(connection.getInputStream());
                Karsı_Tepki = Cevir_StreamToString(Gir);
        }catch (IOException e){ }return  Karsı_Tepki; }
    private String Cevir_StreamToString(InputStream K){
        BufferedReader okuyucu= new BufferedReader(new InputStreamReader(K));
        StringBuilder StrBldr = new StringBuilder();
        String bosluk = "";
        try {
            while ((bosluk = okuyucu.readLine())!=null){ StrBldr.append(bosluk).append("\n"); }
        }catch (IOException e){ }
        finally {
            try { K.close(); }catch (IOException e){ } }return StrBldr.toString(); }}

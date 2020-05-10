package com.example.sehirtanitmakonya42;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class KonyaAdaptorAlihan extends BaseAdapter {
    LayoutInflater layout_Inflater1;
    Context bagla;
    ArrayList<Eser>Eserler;
    public KonyaAdaptorAlihan(Activity activity, ArrayList<Eser> eserler){
        this.Eserler=eserler;
        this.bagla=activity;
        this.layout_Inflater1=(LayoutInflater)activity.getSystemService(bagla.LAYOUT_INFLATER_SERVICE); }
    @Override
    public int getCount() { return Eserler.size(); }
    @Override
    public Object getItem(int position) { return Eserler.get(position); }
    @Override
    public long getItemId(int position) { return position; }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        bagla=parent.getContext();
        View Grid_goruntu=layout_Inflater1.inflate(R.layout.sablon,null);
        ImageView resim=(ImageView)Grid_goruntu.findViewById(R.id.E_resim);
        TextView ad=(TextView)Grid_goruntu.findViewById(R.id.E_ad);
        TextView tarih=(TextView)Grid_goruntu.findViewById(R.id.E_tarih);
        TextView aciklama=(TextView)Grid_goruntu.findViewById(R.id.E_aciklama);
        ad.setText(Eserler.get(position).getEser_ad());
        tarih.setText(Eserler.get(position).getEser_tarih());
        aciklama.setText(Eserler.get(position).getEser_aciklama());
        Picasso.with(bagla).load(Eserler.get(position).getEser_resim()).into(resim);
        return Grid_goruntu; }
}

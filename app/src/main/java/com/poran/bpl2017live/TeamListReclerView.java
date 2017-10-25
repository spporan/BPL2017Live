package com.poran.bpl2017live;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.google.android.gms.ads.AdView;

public class TeamListReclerView extends AppCompatActivity {

    private android.support.v7.widget.RecyclerView recyclerView;
    private android.support.v7.widget.RecyclerView.Adapter mAdapter;
    private android.support.v7.widget.RecyclerView.LayoutManager mLayout;

    private String teamList[]={"ঢাকা ডাইনামাইটস","রংপুর রাইডার্স","রাজশাহী কিংস","কুমিল্লা ভিক্টোরিয়ান্স","খুলনা টাইটানস","সিলেট সুরমা সিক্সার্স","চট্টগ্রাম ভাইকিং"};
    private String budget[]={"২ কোটি ৫২ লাখ","২ কোটি ৬২ লাখ","২ কোটি ৫২ লাখ"," ২ কোটি ৬২ লাখ","২ কোটি ৫৪ লাখ"," ২ কোটি ৩৫ লাখ","২ কোটি ২০ লাখ"};
//    private int teamlogo[]={R.drawable.dhk,R.drawable.rong,R.drawable.raj,R.drawable.comv,
//    R.drawable.kt,R.drawable.syllhet,R.drawable.cvlogo};
    private Context context;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list_recler_view);
        adView=(AdView)findViewById(R.id.adView);
        context=this;

        recyclerView= (android.support.v7.widget.RecyclerView) findViewById(R.id.recyclerview2);
        recyclerView.setHasFixedSize(true);
        AdsView adsView=new AdsView(this,adView);
        adsView.displayInterstitial();
        adsView.makeAdView();



        mLayout=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayout);
        mAdapter=new TeamList(teamList,budget);

        recyclerView.setAdapter(mAdapter);
    }


}

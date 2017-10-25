package com.poran.bpl2017live;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.google.android.gms.ads.AdView;

public class IconPlayerReclerView extends AppCompatActivity {
    private android.support.v7.widget.RecyclerView recyclerView;
    private android.support.v7.widget.RecyclerView.Adapter mAdapter;
    private android.support.v7.widget.RecyclerView.LayoutManager mLayout;
    private String iconPlayer[]={"সাকিব আল হাসান ","মাশরাফি বিন মুর্তজা ","মুশফিকুর রহিম"," তামিম ইকবাল","মাহমুদউল্লাহ রিয়াদ","সাব্বির রহমান"," সৌম্য সরকার"};
    private String price[]={"৫৫","৫০","৫০","৫০","৫০","৫০","৪০"};
    private String team[]={"ঢাকা ডাইনামাইটস","রংপুর রাইডার্স","রাজশাহী কিংস","কুমিল্লা ভিক্টোরিয়ান্স","খুলনা টাইটানস","সিলেট সুরমা সিক্সার্স","চট্টগ্রাম ভাইকিং"};
    Context context;
    private AdView adView;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_player_recler_view);
        context=this;
        recyclerView= (android.support.v7.widget.RecyclerView) findViewById(R.id.recyclerview1);
        recyclerView.setHasFixedSize(true);
        adView=(AdView)findViewById(R.id.adView);
        AdsView adsView=new AdsView(this,adView);
        adsView.makeAdView();
        adsView.displayInterstitial();




        mLayout=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayout);

        mAdapter=new IconPlayerActivity(iconPlayer,price,team);

        recyclerView.setAdapter(mAdapter);


    }
}
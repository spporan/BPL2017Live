package com.poran.bpl2017live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView day,hour,min,sec,event,todaysTeam1,todaysTeam2,todaysTeam3,todaysTeam4,vanue1,vanue2,vs1,vs2;
    private LinearLayout linearLayout1, linearLayout2,todaytitlelayout;
    private ViewFlipper viewFlipper;
    private AdView mAdview;

    private Handler handler;
    private Runnable runnable;
    private Intent intent;
    TodaysMatchAnim td;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uiInit();
        countDown();
        todayMatch();
        mAdview=(AdView)findViewById(R.id.adView);
        AdsView adsView=new AdsView(context,mAdview);
        adsView.makeAdView();
       // makeAdView();




    }
//Todays match showing animationly
    private void todayMatch(){
        td=new TodaysMatchAnim();
        int c=0;
        for(int i=0;i<td.team1.length;i++){
            if(td.getDate().equals(td.dateString[i])){
                if(c==0){
                    c++;

                    if(i<8){
                        todaysTeam1.setText(td.team1[i]);
                        todaysTeam2.setText(td.team2[i]);
                        vanue1.setText("সিলেট বিভাগীয় স্টেডিয়াম");
                        timeSetForFirstMatch(i);
                    }
                    else if((i>8&&i<25)||i>34){
                        todaysTeam1.setText(td.team1[i]);
                        todaysTeam2.setText(td.team2[i]);
                        vanue1.setText("মিরপুর শের-ই-বাংলা জাতীয় স্টেডিয়াম");
                        timeSetForFirstMatch(i); //time Setting method

                    }
                    else if(i>24&&i<35){
                        todaysTeam1.setText(td.team1[i]);
                        todaysTeam2.setText(td.team2[i]);
                        vanue1.setText("জহুর আহমেদ চৌধুরী স্টেডিয়াম");
                      timeSetForFirstMatch(i);
                    }


                }else{

                    c--;
                    if(i<8){
                        todaysTeam3.setText(td.team1[i]);
                        todaysTeam4.setText(td.team2[i]);
                        vanue2.setText("সিলেট বিভাগীয় স্টেডিয়াম");
                        timeSetForSecondMatch(i);
                    }
                    else  if((i>8&&i<25)||i>34){
                        todaysTeam3.setText(td.team1[i]);
                        todaysTeam4.setText(td.team2[i]);
                        vanue2.setText("মিরপুর শের-ই-বাংলা জাতীয় স্টেডিয়াম");
                       timeSetForSecondMatch(i);
                    }
                    else if(i>24&&i<35){
                        todaysTeam3.setText(td.team1[i]);
                        todaysTeam4.setText(td.team2[i]);
                        vanue2.setText("জহুর আহমেদ চৌধুরী স্টেডিয়াম");
                        timeSetForSecondMatch(i);
                    }




                }



            }

        }

    }

    @Override
    protected void onPause() {
        if (mAdview!= null) {
            mAdview.pause();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        makeAdView();
        if (mAdview != null) {
            mAdview.resume();
        }
    }

    private void timeSetForFirstMatch(int i){
        if(i==0||i==8||i==16||i==24||i==42){
            vs1.setText("বনাম\nসময়:দুপুর ২.৩০ টা");
        }
        else {
            vs1.setText("বনাম\nসময়:দুপুর ২.০০ টা");
        }

    }
    private void timeSetForSecondMatch(int i){
        if(i==1||i==9||i==17||i==25||i==43){
            vs2.setText("বনাম\nসময়:সন্ধ্যা ৭.১৫ টা");
        }
        else {
            vs2.setText("বনাম\nসময়:সন্ধ্যা ৭.০০ টা");
        }

    }

    private void uiInit(){
        day= (TextView) findViewById(R.id.day);
        hour= (TextView) findViewById(R.id.hour);
        min= (TextView) findViewById(R.id.min);
        sec= (TextView) findViewById(R.id.sec);

        todaysTeam1=(TextView) findViewById(R.id.teamFortodays1);
        todaysTeam2=(TextView) findViewById(R.id.teamFortodays2);
        todaysTeam3=(TextView) findViewById(R.id.teamFortodays3);
        todaysTeam4=(TextView) findViewById(R.id.teamFortodays4);
        vs1=(TextView) findViewById(R.id.vs1);
        vs2=(TextView) findViewById(R.id.vs2);

        vanue1=(TextView) findViewById(R.id.vanue1);
        vanue2=(TextView) findViewById(R.id.vanue2);

        linearLayout1= (LinearLayout) findViewById(R.id.lay1);

        todaytitlelayout= (LinearLayout) findViewById(R.id.todaysTitle);
        viewFlipper= (ViewFlipper) findViewById(R.id.todaysFlipper);


    }

    @Override
    protected void onDestroy() {
        if (mAdview != null) {
            mAdview.destroy();
        }
        super.onDestroy();
    }

    //count Down method
    private void countDown(){
        handler=new Handler();
        runnable=new Runnable() {
            public void run() {
                handler.postDelayed(this,1000);
                try {
                    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                    Date eventDate=dateFormat.parse("2017-11-03");
                    Date currentDate=new Date();
                    if(!currentDate.after(eventDate)){
                        long diff=(eventDate.getTime()-36000000)-currentDate.getTime();
                        long days=diff/(24*60*60*1000);
                        diff-=days*(24*60*60*1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        day.setText("" + String.format("%02d", days));
                        hour.setText("" + String.format("%02d", hours));
                        min.setText("" + String.format("%02d", minutes));
                        sec.setText("" + String.format("%02d", seconds));
                    }
                    else{
                        linearLayout1.setVisibility(View.GONE);

                        todaytitlelayout.setVisibility(View.VISIBLE);




                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        };handler.postDelayed(runnable,0);

    }
    public void onclick(View view){
        switch (view.getId()){
            case R.id.timeSedeul:
                intent=new Intent(this,Recyclerview.class);
                startActivity(intent);

                break;
            case R.id.live1:
                intent=new Intent(this,LiveCricketActivity.class);
                startActivity(intent);
                break;

            case  R.id.todayMatch:
                intent=new Intent(this,IconPlayerReclerView.class);
                startActivity(intent);
                break;
            case R.id.teamName:
                intent=new Intent(this,TeamListReclerView.class);
                startActivity(intent);
                break;
        }
    }

    private void makeAdView() {
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device.
        final AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdview = (AdView) findViewById(R.id.adView);
        // Start loading the ad in the background.
        mAdview.loadAd(adRequest);
        mAdview.setAdListener(getAdListener(adRequest));
        mAdview.bringToFront();
    }

    private AdListener getAdListener(final AdRequest adRequest) {
        return new AdListener() {
            // hide ad block if none could be found
            @Override
            public void onAdFailedToLoad(int errorCode) {
                mAdview.loadAd(adRequest);
                switch (errorCode) {
                    case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                        break;
                    case AdRequest.ERROR_CODE_INVALID_REQUEST:
                        break;
                    case AdRequest.ERROR_CODE_NETWORK_ERROR:
                        break;
                    case AdRequest.ERROR_CODE_NO_FILL:
                        break;
                }
            }

            @Override
            public void onAdLoaded() {
                findViewById(R.id.adView).setVisibility(View.VISIBLE);
                super.onAdLoaded();
            }
        };


    }
}

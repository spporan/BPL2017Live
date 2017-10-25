package com.poran.bpl2017live;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.InjectView;




public class LiveCricketActivity extends AppCompatActivity {
    @InjectView(R.id.matchUpdates)
    ListView listView;
    CricketLiveScore cricketLiveScore;
    ArrayList<String> matchIds = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();
    CustomArrayAdapter arrayAdapter;
    //    private List<MatchModel> matchList = new ArrayList<>();
    private CustomListAdapter adapter;
    private Context localContext;
    private AdView adView;





    private int runCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_cricket);
        ButterKnife.inject(this);
        cricketLiveScore = (CricketLiveScore) getApplicationContext();
        loadListView();
        callAsynchronousTask();


     loadSharedPreferences();
    }

    private void loadListView() {
        localContext = this;
//        adapter = new CustomListAdapter(this, matchList);
//        listView.setAdapter(adapter);
        listView.setOnItemClickListener(getListener());
//        adapter.notifyDataSetChanged();
    }

    private AdapterView.OnItemClickListener getListener() {
        return new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent fullScoreCard = new Intent(localContext, FullScoreCardActivity.class);
                fullScoreCard.putExtra("matchtitle", titles.get(position));
                fullScoreCard.putExtra("matchlink", matchIds.get(position));
                startActivity(fullScoreCard);
            }

        };
    }

    private void loadSharedPreferences() {
        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this);

//       store application run count
        {
            if (sharedPrefs.contains("alreadyRated")) {
                return;
            }
            if (sharedPrefs.contains("prefRunCount")) {
                runCount = sharedPrefs.getInt("prefRunCount", 0) + 1;
            }
            SharedPreferences.Editor editor = sharedPrefs.edit(); // Open the editor for our settings
            editor.putInt("prefRunCount", runCount); // It is no longer the first run
            editor.apply();
        }
//       ends
    }

    @Override
    protected void onDestroy() {
        //TODO Admob Destroy
        if (adView != null) {
            adView.destroy();
        }
//        if (billingProcessor != null)
//            billingProcessor.release();
        super.onDestroy();
    }

    @Override
    protected void onPause() {


        //TODO adview Pause
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    public void callAsynchronousTask() {
        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            getLiveCricketRss();
                            cricketLiveScore.cleanMatchDetails();
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                        }
                    }
                });
            }
        };
        timer.schedule(doAsynchronousTask, 0, 60000);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void rateOurApplication() {
        AlertDialog.Builder alert = new AlertDialog.Builder(LiveCricketActivity.this);
        alert.setTitle("Rate Us");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id="
                                    + getPackageName())
                    ));
                }
                dialog.dismiss();
                SharedPreferences.Editor editor = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext()).edit(); // Open the editor for our settings
                editor.putInt("alreadyRated", 1);
                editor.apply();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.create();
        alert.show();
    }



    private void getLiveCricketRss() {
        new XmlParser(getApplicationContext());
        new showLiveMatches().execute();
    }


    @Override
    protected void onStop() {

        super.onStop();
    }

    //TODO TRACK   UA-55064123-7
    private class showLiveMatches extends AsyncTask<String, String, String> {
        /**
         * Before starting background thread Show Progress Dialog
         */
        ArrayAdapter<String> adapter;
        int i = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            matchIds = new ArrayList<>();
            titles = new ArrayList<>();
            while (cricketLiveScore.parsing) {
                while (i < cricketLiveScore.matchDetailssubmissions) {
                    titles.add(cricketLiveScore.matchDetails.get(i).matchTitle);
                    matchIds.add(cricketLiveScore.matchDetails.get(i).matchLink);
                    i++;
                }
            }

        }
        @Override
        protected String doInBackground(String... args) {
            // Check for success tag
//            for (int i = 0; i < matchList.size(); i++) {
//                matchList.remove(i);
//            }
//            for (int i = 0; i < titles.size(); i++) {
//                Log.i("title " + i, titles.get(i));
//                int index = 0;
//
////            Sri Lanka Air Force Sports Club 68/2 &  167/10 *
////            Tamil Union Cricket and Athletic Club 650/8
//
//                MatchModel matchModel = new MatchModel();
//                String ar[] = titles.get(i).split(" v ");
//                matchModel.team1 = ar[0];
//                matchModel.team2 = ar[1];
////
//                String removeFromThisPart = "/";
//                Log.i("team1 string ", ar[0]);
//                index = ar[0].indexOf(removeFromThisPart);
//                Log.i("index ", "" + index);
//                index = index - 3;
//                if (index > 0) {
//                    matchModel.team1 = ar[0].substring(0, index);
//                    matchModel.team1_score = ar[0].substring(index);
//                }
//
//                index = ar[1].indexOf(removeFromThisPart);
//                index = index - 3;
//                if (index > 0) {
//                    matchModel.team2 = ar[1].substring(1, index);
//                    matchModel.team2_score = ar[1].substring(index);
//                }
//                matchList.add(matchModel);
//            }
           // adapter = new ArrayAdapter<>(localContext,
                   // android.R.layout.simple_list_item_1, android.R.id.text1, titles.toArray(new String[titles.size()]));

            arrayAdapter=new CustomArrayAdapter(localContext,R.layout.list_row,R.id.title,titles);
            return null;
        }


        protected void onPostExecute(String file_url) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        listView.setAdapter(arrayAdapter);
//                        adapter.notifyDataSetChanged();
                        cricketLiveScore.cleanMatchDetails();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }
}


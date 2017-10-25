package com.poran.bpl2017live;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;

public class PlayerList extends AppCompatActivity {
   private TextView teamTitle,teamIcon,ownplr,abroadplr;
   private String dhakaDeshiPlr="মেহেদী মারুফ,শাদমান ইসলাম,নাদিফ  চৌধুরী,মোসাদ্দেক হোসেন,জহুরুল ইসলাম,মোহাম্মদ শহীদ,আবু হায়দার,নূর আলম সাদ্দাম," +
           "সৈয়দ খালেদ আহমেদ,সাকলাইন সজিব";
    private String dhakaabroadPlr="কুমারা সাঙ্গাকারা, শেন ওয়াটসন,আকিয়াল হোসেন, সুনিল নারিন,কেভন কুপার, শহীদ আফ্রিদি, এভিন লুইস, এসলে গুনারত্নে,গ্র্যামে ক্রমে, মোঃ আমির, নিরশান ডিকওয়ালা, রসফোর্ড বেটন, রেভমন পাওয়েল,জো ডেনি";

    private String ctgDeshiplr="আলাউদ্দিন বাবু ,আল আমিন জুনিয়র,এনামুল হক,ইরফান শুক্কুর,তাসকিন আহমেদ ,শুভাশিষ রয়,ইয়াসির আরাফাত,সানজামুল ইসলাম," +
            "তানবির হায়দার,নাঈম হাসান";
    private String ctgabroadPlr="মিসবাহ উল হক ,দিলশান মুনাওয়ারার,নাজিবুল্লাহ জাদরান,জেরমেইন ব্ল্যাকউড,লুইস রিস,জীবন মেন্ডিস,সিকান্দার রাজা,লিয়াম ডসন," +
            "লুকি রঞ্ছি";

    private String comDeshiplr="ইমরুল কায়েস ,রাকিবুল হাসান,আলোক কাপালি,মোহাম্মদ এনামু্‌, মেহেদী হাসান, লিটন দাস,আল আমিন হোসেন ,মোহাম্মদ সাইফুদ্দিন,মেহেদী হাসান রানা" +
            "আরাফাত সানি,রশিদ খান ";
    private String comabroadplr="মার্লন স্যামুয়েলস,কলিন মুনরো,ফখর জামান,ড্যারেন ব্রাভো,অ্যাঞ্জেলো ম্যাথিউস,শোয়েব মালিক, মোহাম্মদ নবী,সলোমন মিরে ,জস বাটলার," +
            " হাসান আলী,ইমরান খান জুনিয়র,রুম্মান রায়স, ফাহিম আশরাফ,হোসেন আলী,মেহেদি হাসান মিরাজ,নাঈম ইসলাম জুনিয়র, নাহিদুজ্জামান ";
    private String rajDeshiPlr="মমিনুল হক,রনি তালুকদার,কাজী ওনিক,জাকির হাসান,মোস্তাফিজুর রহমান,ফরহাদ রেজা,উসামা মির";
    private String rajabroadPlr=" লেন্ডল সিমন্স,ম্যালকম ওয়ালার,ড্যারেন সামি,সমিত প্যাটেল,লুক রাইট,জেমস ফ্র্যাংকলিন,রাজা আলী দার,মোহাম্মদ সামি,ক্যাস্রিক উইলিয়ামস" +
            "";
    private String syllhetDeshiplr="ইমতিয়াজ হোসেন, নাসির হোসেন,শুভাগত হোম,নুরুল হাসান,আবুল হাসান,কামরুল ইসলাম রাব্বী,মোহাম্মদ শরীফ,তাইজুল ইসলাম" +
            "নাবিল সামাদ,শরীফুল্লাহ";
    private String syllhetabroadPlr="বাবর আজম,রিচার্ড লেভি,রস হোয়াইটলি,ন্দ্রে ম্যাকার্থি,দসুন শানাকা,চাতুরাইং ডি সিলভা, ওয়াদিদু হাসারঙ্গা,আন্দ্রে ফ্লেচার," +
            "ডেভি জ্যাকবস,লিম প্লাংকেট,ক্রিশমার সান্তোকি,উসমান খান,গোলাম মুদাসসার";
    private String rangDeshiplr="শাহরিয়ার নাফিস ,ফজলে মাহমুদ,জিয়াউর রহমান,নাহিদুল ইসলাম,মোহাম্মদ মিঠুন,রুবেল হোসেন,ইবদাত হোসেন,আব্দুর রাজ্জাক,ইলিয়াস সানি," +
            "নাজমুল ইসলাম অপু,সোহাগ গাজী,";
    private String rangabroadplr="অ্যাডাম ল্যাথ ,স্যাম হাইন ,রবি বোপারা ,থিসারা পেরেরা,ডেভিড উইলি,সামিউল্লাহ শেনওয়ারী,জনসন চার্লস,কুশল পেরেরা,স্যামুয়েল বদ্রি" +
            "জহির খান";
    private String khulDeshiplr="আরিফুল হক,নাজমুল হোসেন শান্ত,ইয়াসির আলী,সাইফ হাসান,মুক্তার আলী,আফিফ হোসেন,ধীমান ঘোষ,শফিউল ইসলাম,আবু জাইদ," +
            "ইমরান আলী,মোশাররফ হোসেন রুবেল";
    private String khulabroadplr="ক্রিস লিন, জুনায়েদ খান, রাউলি রুশো, শাদাব খান, শারফরাজ আহমেদ, কাইল অ্যাবট, এস প্রসন্ন,দাউদ মালান ,শেহান জয়সুরিয়া" +
            "কার্লোস ব্র্যাথওয়েট,বেনি হাওয়েল,চ্যাডউইক ওয়ালটন,জফ্রা আর্চার";
    private  int pos;
    private AdView adView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);
        context=this;
        init();
         pos=getIntent().getIntExtra("position",0);
        setPlayer();
        AdsView adsView=new AdsView(this,adView);
        adsView.makeAdView();
        adsView.displayInterstitial();



    }

    private void init(){
       teamTitle= (TextView) findViewById(R.id.teamtitle);
        teamIcon= (TextView) findViewById(R.id.iconplr);
        ownplr= (TextView) findViewById(R.id.plrown);
        abroadplr= (TextView) findViewById(R.id.plrabroad);
        adView=(AdView)findViewById(R.id.adView);


    }

    private  void setPlayer(){
        if(pos==0){
            teamTitle.setText("ঢাকা ডায়নামাইটস ");
            teamIcon.setText("আইকন : সাকিব আল হাসান ");
            ownplr.setText(dhakaDeshiPlr);
            abroadplr.setText(dhakaabroadPlr);
        }
        else if(pos==1){
            teamTitle.setText(" রংপুর রাইডার্স ");
            teamIcon.setText("আইকন :মাশরাফি বিন মুর্তজা ");
            ownplr.setText(rangDeshiplr);
            abroadplr.setText(rangabroadplr);
        }
        else if(pos==2){
            teamTitle.setText("রাজশাহী কিংস ");
            teamIcon.setText("আইকন : মুশফিকুর রহিম  ");
            ownplr.setText(rajDeshiPlr);
            abroadplr.setText(rajabroadPlr);
        }
        else if(pos==3){
            teamTitle.setText(" কুমিল্লা ভিক্টোরিয়ান্স ");
            teamIcon.setText("আইকন :তামিম ইকবাল ");
            ownplr.setText(comDeshiplr);
            abroadplr.setText(comabroadplr);
        }
        else if(pos==4){
            teamTitle.setText("খুলনা টাইটান্স ");
            teamIcon.setText("আইকন :মাহমুদুল্লাহ রিয়াদ ");
            ownplr.setText(khulDeshiplr);
            abroadplr.setText(khulabroadplr);
        }
        else if(pos==5){
            teamTitle.setText("সিলেট সুরমা সিক্সার্স ");
            teamIcon.setText("আইকন :সাব্বির রহমান ");
            ownplr.setText(syllhetDeshiplr);
            abroadplr.setText(syllhetabroadPlr);
        }
        else if(pos==6){
            teamTitle.setText("চট্টগ্রাম ভাইকিং");
            teamIcon.setText("আইকন : সৌম্য সরকার");
            ownplr.setText(ctgDeshiplr);
            abroadplr.setText(ctgabroadPlr);
        }
    }

}

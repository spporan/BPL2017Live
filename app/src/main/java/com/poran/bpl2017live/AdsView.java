package com.poran.bpl2017live;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;



public class AdsView {

    private AdView adView;
    private String INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-1820765674741508/1978735934";
    private InterstitialAd interstitial;
    Context context;

    public AdsView(Context context,AdView adView){
        this.context=context;
        this.adView=adView;

    }

    private AdListener getAdListener() {
        return new AdListener() {
            // hide ad block if none could be found

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.e("ad failed to load", errorCode + "");
                switch (errorCode) {
                    case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                        Log.e("INTERSTITIAL: ", "internal error");
                        break;
                    case AdRequest.ERROR_CODE_INVALID_REQUEST:
                        Log.e("INTERSTITIAL : ", "invalid request");
                        break;
                    case AdRequest.ERROR_CODE_NETWORK_ERROR:
                        Log.e("INTERSTITIAL: ", "network error");
                        break;
                    case AdRequest.ERROR_CODE_NO_FILL:
                        Log.e("INTERSTITIAL : ", "no fill");
                        break;
                }
            }

            // show ad block if one was found
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                interstitial.show();
            }
        };
    }

    // Invoke displayInterstitial() when you are ready to display an interstitial.
    public void displayInterstitial() {

        // Create the interstitial.
        interstitial = new InterstitialAd(context);
        interstitial.setAdUnitId(INTERSTITIAL_AD_UNIT_ID);
        final AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				    .addTestDevice("B45CC4F2554A55FA0412EB1B4AD3CCA6")
                .build();
        // Create ad request.
//		AdRequest adRequest = new AdRequest.Builder().build();
        // Begin loading your interstitial.
        interstitial.loadAd(adRequest);
        interstitial.setAdListener(getAdListener());

        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

    public void makeAdView() {
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device.
        final AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("B45CC4F2554A55FA0412EB1B4AD3CCA6")
                .build();

        // Start loading the ad in the background.
        adView.loadAd(adRequest);
        adView.setAdListener(getAdListener(adRequest));
        adView.bringToFront();
    }

    private AdListener getAdListener(final AdRequest adRequest) {
        return new AdListener() {
            // hide ad block if none could be found
            @Override
            public void onAdFailedToLoad(int errorCode) {
                adView.loadAd(adRequest);
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

            // show ad block if one was found
            @Override
            public void onAdLoaded() {
                adView.setVisibility(View.VISIBLE);
                super.onAdLoaded();
            }
        };
    }


}

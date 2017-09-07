package com.techease.forexproanalyzer;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.NativeExpressAdView;
import com.thefinestartist.finestwebview.FinestWebView;

import static com.techease.forexproanalyzer.R.id.adView;


public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        // Banner Ads Integration

        mAdView = (AdView) findViewById(adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("C04B1BFFB0774708339BC273F8A43708")
                .build();
        mAdView.loadAd(adRequest);


        // Interstial ads integration

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
        AdRequest adReques = new AdRequest.Builder()
                .build();
        mInterstitialAd.loadAd(adReques);
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
               // showInterstitial();
            }
        });


        // Webview intialization

        new FinestWebView.Builder(MainActivity.this)
                .showUrl(false)
                .titleDefault("Forex Pro Analyzer")
                .showIconMenu(false)
                .showIconClose(false)
                .showIconBack(false)
                .backPressToClose(false)
                .show("https://www.forexanalyzerpro.com/")
        ;
        this.finish();




        NativeExpressAdView adView1 = (NativeExpressAdView)findViewById(R.id.nativeadView);

        AdRequest request = new AdRequest.Builder().build();
        adView1.loadAd(request);
        AdView adView = new AdView(this);
       // adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getString(R.string.ad_unit_id));

    }



    @Override
    protected void onPause() {
        mAdView.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdView.resume();
    }
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }


    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    public static boolean isNetworkStatusAvialable (Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
            if(netInfos != null)
                if(netInfos.isConnected())
                    return true;
        }
        return false;
    }

}

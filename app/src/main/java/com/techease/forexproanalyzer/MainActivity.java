package com.techease.forexproanalyzer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thefinestartist.finestwebview.FinestWebView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        new FinestWebView.Builder(MainActivity.this)
                .showUrl(false)
                .titleDefault("Forex Pro Analyzer")
                .showIconMenu(false)
                .showIconClose(false)
                .showIconBack(false)
                .backPressToClose(false)
                .show("https://www.forexanalyzerpro.com/")
                ;
        ;

        this.finish();
    }


}

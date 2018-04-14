package com.shivam.deepikamamproject.fragments;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.shivam.deepikamamproject.R;



/**
 * A simple {@link Fragment} subclass.
 */
public class DistanceVector extends android.app.Fragment {


    public DistanceVector() {
        // Required empty public constructor
    }
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_distance_vector, container, false);
        final TextView textView = rootview.findViewById(R.id.textiewdistancevector);
        final ScrollView scroll1=rootview.findViewById(R.id.scrol6);
        final WebView wb=rootview.findViewById(R.id.web3);
        wb.setWebChromeClient(new MyWebViewClient());

        progressBar = (ProgressBar) rootview.findViewById(R.id.progressBar);
        progressBar.setMax(100);

        BottomNavigationView bottomNavigationView = rootview.findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.descriptions:
                                wb.setVisibility(View.GONE);
                                scroll1.setVisibility(View.VISIBLE);
                                textView.setVisibility(View.VISIBLE);
                                break;
                            case R.id.code:
                                wb.setVisibility(View.VISIBLE);
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                wb.setWebViewClient(new WebViewClient());
                                wb.getSettings().setLoadsImagesAutomatically(true);
                                wb.getSettings().setJavaScriptEnabled(true);
                                wb.getSettings().setJavaScriptEnabled(true);
                                wb.getSettings().setDatabaseEnabled(true);
                                wb.getSettings().setDomStorageEnabled(true);
                                wb.getSettings().setAppCacheEnabled(true);
                                wb.getSettings().setSupportZoom(true);
                                wb.getSettings().setBuiltInZoomControls(true);
                                wb.getSettings().setDisplayZoomControls(true);
                                wb.animate();
                                wb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                                wb.loadUrl("https://ide.codingblocks.com/#/s/9886");

                                break;
                        }
                        return false;
                    }
                });

        return  rootview;}

    private class MyWebViewClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
//            WebViewActivity.this.setValue(newProgress);
            super.onProgressChanged(view, newProgress);
        }
    }
    public void setValue(int progress) {
        progressBar.setProgress(progress);
    }

}

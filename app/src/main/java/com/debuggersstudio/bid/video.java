package com.debuggersstudio.bid;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class video extends AppCompatActivity {
//https://www.youtube.com/watch?v=OxRcLC3s_ss&list=PL8JWmr0-CGXeSwb7io_7F9U1acncEg57y

    public  WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_video);


        if(!isConnected(video.this)){ buildDialog(video.this).show();}
        else {
        Toast.makeText(video.this,"Welcome", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_video);
        webView = (WebView)findViewById(R.id.SoforWeb);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().getDisplayZoomControls();
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.youtube.com/watch?v=OxRcLC3s_ss&list=PL8JWmr0-CGXeSwb7io_7F9U1acncEg57y");

    }


}

    @Override
    public void onBackPressed() {

        if(webView.canGoBack()){
            webView.goBack();
        }else

            super.onBackPressed();
    }

    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null&& mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) return true;
            else return false;
        } else
            return false;
    }

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }
}

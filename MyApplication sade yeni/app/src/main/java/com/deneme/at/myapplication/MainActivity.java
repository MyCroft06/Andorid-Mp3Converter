package com.deneme.at.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.net.URL;

public class MainActivity extends Activity {
    private WebView mywebview;
    private TextView metin;
    private Button btn;

    private InterstitialAd gecisReklam;
    private AdRequest adRequest;

    private EditText textbox;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        metin = (TextView) findViewById(R.id.textView);
        metin.setBackgroundColor(Color.TRANSPARENT);
        mywebview = (WebView) findViewById(R.id.webView);
        mywebview.setBackgroundColor(Color.TRANSPARENT);
        textbox = (EditText)findViewById(R.id.editText);
        btn = (Button)findViewById(R.id.button);
        btn.setEnabled(false);
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        textbox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
               // btn.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(textbox.getText().toString().trim().equals("") )
                {
                    btn.setEnabled(false);
                }
                else
                {
                    btn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //btn.setEnabled(true);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String myString = textbox.getText().toString();
                int sayi=myString.length();
                if(sayi>=18)
                {
                    String at = myString.substring(0,17);

                    if(at.equals("https://youtu.be/"))
                    {
                        mywebview.setVisibility(View.VISIBLE);
                        mywebview.loadUrl("https://youtube7.download/mini.php?id=" + myString.substring(17, myString.length()));
                    }
                    else
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Dikkat");
                        builder.setMessage("Sadece Youtube!!!");
                        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                        builder.show();
                    }
                }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Dikkat");
                    builder.setMessage("Sadece Youtube!!!");
                    builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                    builder.show();
                }
            }
        });
    }
}
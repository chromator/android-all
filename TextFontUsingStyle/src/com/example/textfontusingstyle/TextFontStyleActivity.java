package com.example.textfontusingstyle;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TextFontStyleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_font_style);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.text_font_style, menu);
        return true;
    }
    
}

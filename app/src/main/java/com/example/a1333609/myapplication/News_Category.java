package com.example.a1333609.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class News_Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news__category);
    }


    public void switchToNewsDisplay(View v)
    {
        Intent intent = new Intent(this, News_Display.class);

        startActivity(intent);
    }
}

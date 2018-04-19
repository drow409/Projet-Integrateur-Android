package com.example.a1333609.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void switchToNews(View view)
    {
        Intent intent = new Intent(this, News_Category.class);

        startActivity(intent);
    }

    public void switchToParametre(View view)
    {
        Intent intent = new Intent(this, User_Settings.class);

        startActivity(intent);
    }

    public void switchToCategory(View view)
    {
        Intent intent = new Intent(this, Category_Settings.class);

        startActivity(intent);
    }

}

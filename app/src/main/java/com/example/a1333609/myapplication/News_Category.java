package com.example.a1333609.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.a1333609.data_structure.Category;
import com.example.a1333609.data_structure.DataStructureElement;
import com.example.a1333609.data_structure.DataStructureManager;

import org.json.JSONObject;

import java.util.ArrayList;

public class News_Category extends AppCompatActivity {

    public ArrayList<String> sArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news__category);

        sArray = new ArrayList<String>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, sArray);

        ListView lv = ((ListView)findViewById(R.id.list));
        lv.setAdapter(adapter);

        populateCategory(DataStructureManager.getRootCategories());
    }

    public void populateCategory(Category parent)
    {
        for(DataStructureElement e : parent.getElements())
        {
            sArray.add(e.getDisplayName());
        }
    }



    public void switchToNewsDisplay(View v)
    {
        Intent intent = new Intent(this, News_Display.class);

        startActivity(intent);
    }
}

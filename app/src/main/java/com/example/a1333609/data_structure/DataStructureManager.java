package com.example.a1333609.data_structure;

import android.content.Context;
import android.util.Log;

import com.example.a1333609.data_structure.Category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 1333609 on 2018-04-24.
 */

public abstract class DataStructureManager {

    private static Category categories;

    public static final String JSON_FILE_NAME = "DataStructure";
    public static final String ID_NODE_NAME = "id";
    public static final String DISPLAY_NAME_NODE_NAME = "displayName";
    public static final String CATEGORY_LIST_NODE_NAME = "categoryList";
    public static final String NEWS_LIST_NODE_NAME = "newsList";
    public static final String HTML_CONTENT_NODE_LIST = "htmlContent";

    public static Category getRootCategories()
    {
        if(categories == null) {
            categories = new Category("main", "Main");
        }
        return categories;
    }

    public static Category getDataStructureFromJson(JSONObject json){

        Category cat = new Category("", "");

        try {
            JSONArray mainCatArray = json.getJSONArray(CATEGORY_LIST_NODE_NAME);

            cat = returnSubContent(cat, mainCatArray);
        }catch(JSONException e)
        {

        }
        return cat;
    }

    private static Category returnSubContent(Category parentCategory, JSONArray jarray) throws JSONException {
        for(int j = 0; j < jarray.length(); j++)
        {
            JSONObject jsonObj = jarray.getJSONObject(j);
            //go get the news list
            JSONArray newsList = jsonObj.getJSONArray(NEWS_LIST_NODE_NAME);

            for(int i = 0; i < newsList.length(); i++)
            {
                JSONObject jsonNews = newsList.getJSONObject(i);

                News n = new News(jsonNews.getString(ID_NODE_NAME), jsonNews.getString(DISPLAY_NAME_NODE_NAME), jsonNews.getString("htmlContent"));

                parentCategory.getElements().add(n);
            }

            //go get the category list
            JSONArray categoryList = jsonObj.getJSONArray(CATEGORY_LIST_NODE_NAME);
            for(int i = 0; i < categoryList.length(); i++)
            {
                Category subC = new Category("", "");

                subC = returnSubContent(subC, categoryList);

                parentCategory.getElements().add(subC);
            }
        }
        return parentCategory;
    }

    private static News createNews() {
        return null;
    }

    public static JSONObject testJSONCreation()
    {
        JSONObject jsonCategories = new JSONObject();
        JSONArray jsonMainCatArray = new JSONArray();
        try {
            jsonCategories.put(CATEGORY_LIST_NODE_NAME, jsonMainCatArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i("JSON", jsonCategories.toString());

        return jsonCategories;
    }

    /**
     * saves a given JSONObject to the internal storage
     * @param context
     * @param json
     */
    public static void saveJSON(Context context, JSONObject json)
    {
        String filename = JSON_FILE_NAME;
        String fileContent = json.toString();
        try{
            FileOutputStream out = context.openFileOutput(filename, Context.MODE_PRIVATE);
            out.write(fileContent.getBytes());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject loadJSON(Context context)
    {
        JSONObject json = new JSONObject();
        String filename = JSON_FILE_NAME;
        try{
            Log.i("ping", "start reading");
            File f = new File(context.getFilesDir(), filename);
            FileInputStream in = new FileInputStream(f);
            String temp = "";
            int content;
            while ((content = in.read()) != -1) {
                // convert to char and display it
                temp += (char) content;
            }
            json = new JSONObject(temp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * permet de crée un élément JSON représentant une nouvelle
     * @param id
     * @param title
     * @param html
     * @return
     */
    public static JSONObject createJSONNews(String id, String title, String html)
    {
        JSONObject json = new JSONObject();

        try {
            json.put(ID_NODE_NAME, id);
            json.put(DISPLAY_NAME_NODE_NAME, title);
            json.put(HTML_CONTENT_NODE_LIST, html);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }

    /**
     * permet de crée un élément JSON représentant une catégorie
     * @param id
     * @param displayName
     * @return
     */
    public static JSONObject createJSONCategory(String id, String displayName)
    {
        JSONObject json = new JSONObject();

        try {
            json.put(ID_NODE_NAME, id);
            json.put(DISPLAY_NAME_NODE_NAME, displayName);
            json.put(CATEGORY_LIST_NODE_NAME, new JSONArray());
            json.put(NEWS_LIST_NODE_NAME, new JSONArray());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }
}

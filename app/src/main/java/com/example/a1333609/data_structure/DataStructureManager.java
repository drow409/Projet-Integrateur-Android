package com.example.a1333609.data_structure;

import android.util.Log;

import com.example.a1333609.data_structure.Category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by 1333609 on 2018-04-24.
 */

public abstract class DataStructureManager {

    private static Category categories;

    public static void initDataStructure()
    {
        if(categories == null) {
            categories = new Category("main", "Main");
        }
    }

    public static Category getDataStructudeFromJson(JSONObject json) throws JSONException {

        Category cat = new Category();

        JSONArray mainCatArray = json.getJSONArray("categoryList");

        cat = returnSubContent(cat, mainCatArray);

        return cat;
    }

    private static Category returnSubContent(Category parentCategory, JSONArray jarray) throws JSONException {
        for(int j = 0; j < jarray.length(); j++)
        {
            JSONObject jsonObj = jarray.getJSONObject(j);
            //go get the news list
            JSONArray newsList = jsonObj.getJSONArray("newsList");

            for(int i = 0; i < newsList.length(); i++)
            {
                JSONObject jsonNews = newsList.getJSONObject(i);

                News n = new News(jsonNews.getString("id"), jsonNews.getString("title"), jsonNews.getString("htmlContent"));

                parentCategory.elements.add(n);
            }

            //go get the category list
            JSONArray categoryList = jsonObj.getJSONArray("categoryList");
            for(int i = 0; i < categoryList.length(); i++)
            {
                Category subC = new Category();

                subC = returnSubContent(subC, categoryList);

                parentCategory.elements.add(subC);
            }
        }
        return parentCategory;
    }

    private static News createNews()
    {
        return null;
    }

    private static void writeJSON()
    {
        //File file = new File(this.getFilesDir(), filename);
    }

    public static void testJSONCreation()
    {
        JSONObject jsonCategories = new JSONObject();
        JSONArray jsonMainCatArray = new JSONArray();
        try {
            jsonCategories.put("categories", jsonMainCatArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i("JSON", jsonCategories.toString());
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
            json.put("id", id);
            json.put("title", title);
            json.put("htmlContent", html);
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
            json.put("id", id);
            json.put("displayName", displayName);
            json.put("categories", new JSONArray());
            json.put("newsList", new JSONArray());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }
}

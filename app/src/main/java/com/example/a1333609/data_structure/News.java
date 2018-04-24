package com.example.a1333609.data_structure;

/**
 * représentation d'une nouvelle. Contiens du HTML qui va être afficher par l'interface via une WebView
 */

public class News implements DataStructureElement{

    public String id;
    public String title;
    public String html;

    public News(String id, String title, String htmlContent)
    {
        this.id = id;
        this.title = title;
        this.html = htmlContent;
    }
}

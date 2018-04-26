package com.example.a1333609.data_structure;

/**
 * représentation d'une nouvelle. Contiens du HTML qui va être afficher par l'interface via une WebView
 */

public class News extends DataStructureElement{

    public String html;

    public News(String id, String displayName, String htmlContent)
    {
        super(id, displayName);
        this.html = htmlContent;
    }
}

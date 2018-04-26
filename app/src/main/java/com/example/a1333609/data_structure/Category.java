package com.example.a1333609.data_structure;

import java.util.ArrayList;

/**
 * Une catégorie de nouvelle. Peut contenir des nouvelles ou des sous-catégories. En théorie, une catégorie ayant des sous-catégories
 * ne devrais pas contenir de nouvelles, mais l'application va être quand même être en mesure de le supporter.
 */

public class Category extends DataStructureElement{

    private String id;
    private String displayName;
    private ArrayList<DataStructureElement> elements;

    public Category(String id, String displayName)
    {
        super(id, displayName);
        this.elements = new ArrayList<DataStructureElement>();
    }

    public String getId()
    {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public ArrayList<DataStructureElement> getElements() {
        return elements;
    }




}

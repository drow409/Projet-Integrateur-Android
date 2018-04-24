package com.example.a1333609.data_structure;

import java.util.ArrayList;

/**
 * Une catégorie de nouvelle. Peut contenir des nouvelles ou des sous-catégories. En théorie, une catégorie ayant des sous-catégories
 * ne devrais pas contenir de nouvelles, mais l'application va être quand même être en mesure de le supporter.
 */

public class Category implements DataStructureElement{

    public String id;
    public String displayName;
    public ArrayList<DataStructureElement> elements;

    public Category()
    {
        this("", "");
    }

    public Category(String id, String displayName)
    {
        this.id = id;
        this.displayName = displayName;
        this.elements = new ArrayList<DataStructureElement>();
    }

}

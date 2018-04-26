package com.example.a1333609.data_structure;

/**
 * Created by 1333609 on 2018-04-24.
 */

public abstract class DataStructureElement {

    protected String id;
    protected String displayName;

    public DataStructureElement(String id, String displayName)
    {
        this.id = id;
        this.displayName = displayName;
    }

    public String getId()
    {
        return id;
    }

    public String getDisplayName()
    {
        return displayName;
    }
}

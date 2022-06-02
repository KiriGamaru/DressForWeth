package com.example.dressforweth.data;

import com.example.dressforweth.Clothes;
import com.example.dressforweth.R;

import java.util.ArrayList;

public class ClothesList {

    private static ClothesList instance = null;
    private final ArrayList<Clothes> clothesList = new ArrayList<>();

    public ClothesList(){
        clothesList.add(new Clothes( R.drawable.futbolka, "футблока","это футболка"));
        clothesList.add(new Clothes(R.drawable.kurtka,"куртка","это куртка"));
        clothesList.add(new Clothes(R.drawable.ked,"кеды","это кеды"));
    }

    public static ClothesList getInstance()
    {
        if (instance==null)
        {
            instance =new ClothesList();
        }
        return instance;
    }

    public ArrayList<Clothes> getClothes() {
        return clothesList;
    }
}

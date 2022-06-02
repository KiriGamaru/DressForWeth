package com.example.dressforweth.data;

import java.util.ArrayList;

public class ClothesList {

    private static ClothesList instance = null;
    private final ArrayList<Clothes> clothesList = new ArrayList<>();

    public ClothesList(){
        clothesList.add(new Clothes("футблока","это футболка","futbolka.jpg"));
        clothesList.add(new Clothes("куртка","это куртка","kurtka.jpg"));
        clothesList.add(new Clothes("кеды","это кеды","ked.jpg"));
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

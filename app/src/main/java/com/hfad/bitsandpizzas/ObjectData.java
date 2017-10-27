package com.hfad.bitsandpizzas;

/**
 * Created by davidg on 04/05/2017.
 */

public class ObjectData {
    private String name;
    private int imageResourceId;

    public static final ObjectData[] pizzas = {
            new ObjectData("Diavolo", R.drawable.diavolo),
            new ObjectData("Funghi", R.drawable.funghi),
            new ObjectData("\'Murican", R.drawable.diavolo),
            new ObjectData("National", R.drawable.funghi),
            new ObjectData("Ferderal", R.drawable.diavolo)
    };
    public static final ObjectData[] pastas = {
            new ObjectData("Pasta1", R.drawable.pasta1),
            new ObjectData("Pasta2", R.drawable.pasta2),
            new ObjectData("Pasta3", R.drawable.pasta3),
            new ObjectData("Pasta4", R.drawable.pasta4),
            new ObjectData("Pasta5", R.drawable.pasta5)
    };
    public static final ObjectData[] stores = {
            new ObjectData("Store1", R.drawable.restaurantpic1),
            new ObjectData("Store2", R.drawable.restaurantpic2),
            new ObjectData("Store3", R.drawable.restaurantpic3),
            new ObjectData("Store4", R.drawable.restaurantpic4),
            new ObjectData("Store5", R.drawable.restaurantpic5)
    };

    private ObjectData(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }
    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
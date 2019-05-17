package com.example.hotpotato;

public class Recipes {

    private String name;
    private int imageResourceId;

    public static final Recipes[] recipes = {
            new Recipes("Backed potatoes", R.drawable.diavolo),
            new Recipes("Fried potatoes", R.drawable.funghi)
    };

    private Recipes(String name, int imageResourceId) {
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

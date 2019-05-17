package com.example.hotpotato;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.GridLayoutManager;
import android.content.Intent;

import java.lang.reflect.Array;


public class AllRecipeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recipeRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_all_recipe, container, false);

        String[] recipeNames = new String[Recipes.recipes.length];
        for (int i = 0; i < recipeNames.length; i++) {
            recipeNames[i] = Recipes.recipes[i].getName();
        }

        int[] recipeImages = new int[Recipes.recipes.length];
        for (int i = 0; i < recipeImages.length; i++) {
            recipeImages[i] = Recipes.recipes[i].getImageResourceId();
        }

        CaptionedImageAdapter adapter = new CaptionedImageAdapter(recipeNames, recipeImages);
        recipeRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recipeRecycler.setLayoutManager(layoutManager);

        //Implementing the Listener onClick() method. It starts RecipeDetailActivity,
        // passing it the ID of the recipe the user chose.
        adapter.setListener(new CaptionedImageAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), RecipeDetailActivity.class);
                intent.putExtra(RecipeDetailActivity.EXTRA_RECIPE_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return recipeRecycler;
    }
}

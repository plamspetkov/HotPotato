package com.example.hotpotato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.content.ContextCompat;

public class RecipeDetailActivity extends AppCompatActivity {

    public static final String EXTRA_RECIPE_ID = "recipeId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        //Set the toolbar as the activity's app bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Display details of the recipe
        int recipeId = (Integer)getIntent().getExtras().get(EXTRA_RECIPE_ID);
        String recipeName = Recipes.recipes[recipeId].getName();
        TextView textView = (TextView)findViewById(R.id.recipe_text);
        textView.setText(recipeName);
        int recipeImage = Recipes.recipes[recipeId].getImageResourceId();
        ImageView imageView = (ImageView)findViewById(R.id.recipe_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, recipeImage));
        imageView.setContentDescription(recipeName);
    }
}

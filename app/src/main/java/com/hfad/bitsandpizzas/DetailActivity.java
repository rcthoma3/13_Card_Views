package com.hfad.bitsandpizzas;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "detailId";
    public static final String TYPE_ID = "detailType";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        //Set the toolbar as the activity's app bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Display details of the pizza
        int detailId = (Integer) getIntent().getExtras().get(EXTRA_ID);
        int detailType = (Integer) getIntent().getExtras().get(TYPE_ID);

        String detailName;
        int detailImage;

        if (detailType == 0) {
            detailName = ObjectData.pizzas[detailId].getName();
            detailImage = ObjectData.pizzas[detailId].getImageResourceId();
        }
        else if (detailType == 1) {
            detailName = ObjectData.pastas[detailId].getName();
            detailImage = ObjectData.pastas[detailId].getImageResourceId();
        }
        else if (detailType == 2) {
            detailName = ObjectData.stores[detailId].getName();
            detailImage = ObjectData.stores[detailId].getImageResourceId();
        }
        else {
            //PLACEHOLDER, SHOULD NOT BE REACHED
            detailName = ObjectData.stores[detailId].getName();
            detailImage = ObjectData.stores[detailId].getImageResourceId();
        }
        ImageView imageView = (ImageView)findViewById(R.id.pizza_image);

        TextView textView = (TextView)findViewById(R.id.pizza_text);
        textView.setText(detailName);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, detailImage));
        imageView.setContentDescription(detailName);
    }
}
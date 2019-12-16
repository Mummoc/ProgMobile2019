package com.example.mtgcardsearcher.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mtgcardsearcher.R;
import com.example.mtgcardsearcher.model.Card;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView cardImage = (ImageView)findViewById(R.id.item_image);
        TextView oracleText = (TextView)findViewById(R.id.oracle_text);

        String json = getIntent().getStringExtra("Card");
        Gson gson = new Gson();
        Card card = gson.fromJson(json, Card.class);

        oracleText.setText(card.getText());
        Picasso.get().load(card.getImageUrl()).into(cardImage);
    }
}

package com.example.mtgcardsearcher.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mtgcardsearcher.R;
import com.example.mtgcardsearcher.controller.MainActivityController;
import com.example.mtgcardsearcher.model.Card;
import com.example.mtgcardsearcher.model.MtgSet;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    private MainActivityController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast refreshToast = Toast.makeText(this,"Chargement, veuillez patientez, cela peux prendre un peu de temps."
                ,Toast.LENGTH_SHORT);
        refreshToast.show();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        this.controller = new MainActivityController(this, getBaseContext().getSharedPreferences("PREFS", MODE_PRIVATE));

        String setCode = getIntent().getStringExtra("SetCode");

        controller.loadCards(setCode);
    }

    public void showList(MtgSet input) {
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new Adapter(input,this, getListener());
        recyclerView.setAdapter(myAdapter);
    }

    private OnItemClickListener getListener(){
        return new OnItemClickListener() {
            @Override
            public void onItemClick(Card item) {
                Intent intent = new Intent (getApplicationContext(), SecondActivity.class);
                Gson gson = new Gson();
                String card = gson.toJson(item);
                intent.putExtra("Card", card);

                startActivity(intent);
            }
        };
    }
}

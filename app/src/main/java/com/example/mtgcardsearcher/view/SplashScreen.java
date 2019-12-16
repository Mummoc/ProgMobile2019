package com.example.mtgcardsearcher.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import com.example.mtgcardsearcher.R;
import com.example.mtgcardsearcher.controller.SplashController;
import com.example.mtgcardsearcher.model.MtgSet;
import java.util.List;

public class SplashScreen extends AppCompatActivity {

    private SplashController controller;
    private String[] setNames;
    private String[] setCodes;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        controller = new SplashController(this, getBaseContext().getSharedPreferences("PREFS", MODE_PRIVATE));
        controller.loadSets();
    }

    public void showSets(List<MtgSet> setList){
        Intent i = new Intent(getApplicationContext(), setChoiceActivity.class);

        setNames = getNames(setList);
        setCodes = getCodes(setList);

        i.putExtra("SetCodes", setCodes);
        i.putExtra("SetNames", setNames);

        startActivity(i);
    }

    private String[] getNames(List<MtgSet> sets){
        String[] setNames = new String[sets.size()];
        int i = 0;
        while (i < sets.size()){
            setNames[i]=sets.get(i).getName();
            i++;
        }
        return setNames;
    }

    private String[] getCodes(List<MtgSet> sets){
        String[] setNames = new String[sets.size()];
        int i = 0;
        while (i < sets.size()){
            setNames[i]=sets.get(i).getCode();
            i++;
        }
        return setNames;
    }

}
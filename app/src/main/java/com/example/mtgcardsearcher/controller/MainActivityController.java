package com.example.mtgcardsearcher.controller;


import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.example.mtgcardsearcher.model.MtgSet;
import com.example.mtgcardsearcher.model.SetAPI;
import com.example.mtgcardsearcher.view.MainActivity;

import java.util.List;

public class MainActivityController {

    private MainActivity activityMain;
    private SharedPreferences sharedPreferences;

    public MainActivityController(MainActivity mainActivity, SharedPreferences sharedPreferences) {
        this.activityMain = mainActivity;
    }

    public void loadCards(String setCode){
        AsyncTaskLoadCards myTask = new AsyncTaskLoadCards();
        myTask.execute(setCode);
    }

    private class AsyncTaskLoadCards extends AsyncTask<String,Void,MtgSet>{
        @Override
        protected MtgSet doInBackground(String... setCode) {
            return SetAPI.getSet(setCode[0]);
        }

        @Override
        protected void onPostExecute(MtgSet set){
            activityMain.showList(set);
        }

    }
}

package com.example.mtgcardsearcher.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.example.mtgcardsearcher.model.MtgSet;
import com.example.mtgcardsearcher.model.SetAPI;
import com.example.mtgcardsearcher.view.SplashScreen;
import com.example.mtgcardsearcher.view.setChoiceActivity;
import com.google.gson.Gson;

import java.util.List;

public class SplashController {

    private SplashScreen activity;
    private SharedPreferences sharedPreferences;


    public SplashController(SplashScreen activity, SharedPreferences sharedPreferences){
        this.activity = activity;
        this.sharedPreferences = sharedPreferences;
    }

    public void loadSets(){
        AsyncTaskLoadSets myTask = new AsyncTaskLoadSets();
        myTask.execute();
    }


    private class AsyncTaskLoadSets extends AsyncTask<Void, Void, List<MtgSet>> {

        @Override
        protected List<MtgSet> doInBackground(Void... voids) {
            return SetAPI.getAllSets();
        }

        @Override
        protected void onPostExecute(List<MtgSet> val){
            activity.showSets(val);
        }
    }
}

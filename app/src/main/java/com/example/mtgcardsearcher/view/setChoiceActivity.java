package com.example.mtgcardsearcher.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mtgcardsearcher.R;

public class setChoiceActivity extends AppCompatActivity {

    Button myButton;
    String[] setNames;
    String[] setCodes;

    protected void onCreate(Bundle savedInstanceData){
        super.onCreate(savedInstanceData);
        setContentView(R.layout.activity_set_choice);

        myButton = (Button) findViewById(R.id.button);

        setNames = getIntent().getStringArrayExtra("SetNames");
        setCodes = getIntent().getStringArrayExtra("SetCodes");

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(setChoiceActivity.this);
                myBuilder.setTitle("Choisissez un set.");

                myBuilder.setSingleChoiceItems(setNames, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                        intent.putExtra("SetCode", setCodes[i]);
                        startActivity(intent);
                    }
                });
                AlertDialog mDialog = myBuilder.create();
                mDialog.show();
            }
        });
    }
}

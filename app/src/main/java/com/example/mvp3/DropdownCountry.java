package com.example.mvp3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.os.Bundle;
import android.widget.Button;

import java.util.Collections;

public class DropdownCountry extends AppCompatActivity {
    Button confirmcountry;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropdown_country);

        String[] languages = getResources().getStringArray(R.array.Country_Name);
        @SuppressLint("ResourceType") ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, languages);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.RED);

        confirmcountry = (Button) findViewById(R.id.ConfirmCountry);
        confirmcountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHouseActivity();
            }
        });


    }
    public void openHouseActivity(){
        Intent intent = new Intent(this, DropdownHouse.class);
        startActivity(intent);
    }
}
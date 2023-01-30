package com.example.mvp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.Slider;

import java.text.NumberFormat;


public class Vehicle extends AppCompatActivity {

    Button confirmvehicle;


    TextView selectedVehicle;
    NumberPicker vehiclePicker;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        confirmvehicle = (Button) findViewById(R.id.ConfirmVehicle);
        confirmvehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openDietActivity();}});


        selectedVehicle = (TextView) findViewById(R.id.SelectedVehicle);
        vehiclePicker = (NumberPicker) findViewById(R.id.VehiclePicker);

        Slider slider = (Slider) findViewById(R.id.kmsSlider);
        TextView howManyKms = findViewById(R.id.howmanykms);
//        int kms = (int) slider.getValue();

        slider.setLabelFormatter(new LabelFormatter() {
            @NonNull
            @Override
            public String getFormattedValue(float value) {
                NumberFormat kms = NumberFormat.getNumberInstance();
                howManyKms.setText("Distance Travelled in one day: " + kms.format(value)+ " kms");

                return kms.format(value) + " kms";

            }
        });


        //Populate NumberPicker values from minimum and maximum value range


        //Populate NumberPicker values from String array values
        final String[] values = {"Public transport","Bike/Scooter","Car","Petrol car","Diesel","Gas car","Electric"};

        vehiclePicker.setMinValue(0);
        vehiclePicker.setMaxValue(values.length - 1);
        vehiclePicker.setDisplayedValues(values);
        vehiclePicker.setWrapSelectorWheel(true);

        vehiclePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

                selectedVehicle.setText("Selected Vehicle : " + values[i1]);

            }
        });
    }

    public void openDietActivity(){
        Intent intent = new Intent(this, Shopping.class);
        startActivity(intent);
    }

}
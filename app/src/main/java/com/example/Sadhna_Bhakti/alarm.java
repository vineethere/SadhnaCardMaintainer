package com.example.Sadhna_Bhakti;


import android.Manifest;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class alarm extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{
    private Button cancel;
    private Button settime;

//    private final static int REQUEST_CODE_ASK_PERMISSIONS = 1;
    private static final String[] REQUIRED_SDK_PERMISSIONS = new String[] {
            Manifest.permission.SCHEDULE_EXACT_ALARM};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        cancel=findViewById(R.id.cancel);
        settime=findViewById(R.id.settime);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        prefs.edit().putBoolean("isalarm",false).apply();
        prefs.edit().putInt("hour",-1).apply();
        prefs.edit().putInt("min",-1).apply();
        settime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timepicker=new TimePickerFragment();
                timepicker.show(getSupportFragmentManager(),"Time Picker");
                 prefs.edit().putBoolean("isalarm",true).commit();
            }


        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.edit().putBoolean("isalarm",false).commit();
                startActivity(new Intent(alarm.this,MainActivity.class));finish();
            }
        });
    }


    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        prefs.edit().putInt("hour",i).commit();
        prefs.edit().putInt("min",i1).commit();
        startActivity(new Intent(alarm.this,MainActivity.class));finish();
    }
    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(alarm.this,index.class));
    }
}
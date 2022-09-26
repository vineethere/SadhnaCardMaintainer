package com.example.quizapp;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.quizapp.data.DbHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

public class a8 extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    private Button login;
    private Button tv_timer;
    String ans="-1";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q8);
        login=findViewById(R.id.Login);
        tv_timer=findViewById(R.id.tv_timer);
        tv_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timepicker=new TimePickerFragment();
                timepicker.show(getSupportFragmentManager(),"Time Picker");
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ans=="-1"){
                    Toast.makeText(a8.this, "Select time firsgt", Toast.LENGTH_SHORT).show();
                }
                else {
                    DbHandler db=new DbHandler(a8.this);
                    db.update_ans8(date,ans);

                    Toast.makeText(a8.this, ans, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(a8.this, a9.class));
                }
            }
        });
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        ans=hourOfDay+":"+minute;
    }
}
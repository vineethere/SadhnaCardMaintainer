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

public class a5 extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{
    private Button no;
    private Button half;

    private Button tv_timer;
    private Button full;
    String ans="-1";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q5);
        full=findViewById(R.id.full);
        half=findViewById(R.id.half);
        no=findViewById(R.id.no);
        tv_timer=findViewById(R.id.tv_timer);
        full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ans == "-1") {
                    Toast.makeText(a5.this, "Please select time too", Toast.LENGTH_SHORT).show();
                } else {
                    ans += "full";
                    DbHandler db=new DbHandler(a5.this);
                    db.update_ans5(date,ans);
                    Toast.makeText(a5.this, ans, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(a5.this, a6.class));finish();
                }
            }
        });
        tv_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timepicker=new TimePickerFragment();
                timepicker.show(getSupportFragmentManager(),"Time Picker");
            }
        });
        half.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ans == "-1") {
                    Toast.makeText(a5.this, "Please select time too", Toast.LENGTH_SHORT).show();
                } else {
                ans+=" half";
                    DbHandler db=new DbHandler(a5.this);
                    db.update_ans5(date,ans);
                    Toast.makeText(a5.this, ans, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(a5.this,a6.class));finish();
             }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans="no";
                DbHandler db=new DbHandler(a5.this);
                db.update_ans5(date,ans);
                Toast.makeText(a5.this, ans, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(a5.this,a6.class));finish();
            }
        });
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        ans=hourOfDay+":"+minute+" ";
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(a5.this, a4.class));
        finish();
    }
}
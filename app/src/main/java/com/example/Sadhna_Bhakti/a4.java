package com.example.Sadhna_Bhakti;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


import com.example.Sadhna_Bhakti.data.DbHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

public class a4 extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{
    private Button login;
    private Button tv_timer,no;
    int hour,minute;String ans="-1";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q4);
        login=findViewById(R.id.Login);
        tv_timer=findViewById(R.id.tv_timer);
        no=findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans="no";
                DbHandler db=new DbHandler(a4.this);
                db.update_ans4(date,ans);
                Toast.makeText(a4.this, ans, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(a4.this,a5.class));finish();
            }
        });
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
                if(ans=="-1")
                    Toast.makeText(a4.this, "Pls enter time", Toast.LENGTH_SHORT).show();
                else{
                    DbHandler db=new DbHandler(a4.this);
                    db.update_ans4(date,ans);
                    Toast.makeText(a4.this, ans, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(a4.this,a5.class));finish();
                }
            }
        });
    }


    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        ans=i+":"+i1;
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(a4.this, a3.class));
        finish();
    }
}
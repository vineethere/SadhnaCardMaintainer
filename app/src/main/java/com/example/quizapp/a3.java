package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import  com.example.quizapp.data.DbHandler;

import java.text.SimpleDateFormat;
import java.util.Date;


public class a3 extends AppCompatActivity {
    private Button login;
    private EditText password;
    private Button tv_timer;
    private EditText hour,minute;String ans;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q3);
        login=findViewById(R.id.Login);
        hour=findViewById(R.id.hour);
        minute=findViewById(R.id.min);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                     if(TextUtils.isEmpty(minute.getText().toString())){
                      Toast.makeText(a3.this, "Please enter minute", Toast.LENGTH_SHORT).show();
                     }
                     else {
                        String h=hour.getText().toString();
                        String m=minute.getText().toString();
                         ans = h + ":" + m;
                         DbHandler db=new DbHandler(a3.this);
                         db.update_ans3(date,ans);
                         Toast.makeText(a3.this, ans, Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(a3.this, a4.class));
                      }
            }
        });
    }
}
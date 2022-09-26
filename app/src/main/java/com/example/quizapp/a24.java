package com.example.quizapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.quizapp.data.DbHandler;

import java.text.SimpleDateFormat;
import java.util.Date;


public class a24 extends AppCompatActivity {
    private Button no;
    private Button yes;
    String ans;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());
    @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.q24);
            yes=findViewById(R.id.yes);
            no=findViewById(R.id.No);
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ans="yes";
                    DbHandler db=new DbHandler(a24.this);
                    db.update_ans24(date,ans);
                    Toast.makeText(a24.this, ans, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(a24.this,a25.class));
                }
            });
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ans="no";
                    DbHandler db=new DbHandler(a24.this);
                    db.update_ans24(date,ans);
                    Toast.makeText(a24.this, ans, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(a24.this,a25.class));
                }
            });
        }
    }
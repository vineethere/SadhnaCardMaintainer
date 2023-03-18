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

public class a26 extends AppCompatActivity {
    private Button yes;
    String ans;
    private Button no;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q26);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans="yes";
                DbHandler db=new DbHandler(a26.this);
                db.update_ans26(date,ans);
                Toast.makeText(a26.this, ans, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(a26.this,a27.class));finish();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans="no";
                DbHandler db=new DbHandler(a26.this);
                db.update_ans26(date,ans);
                Toast.makeText(a26.this, ans, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(a26.this,a27.class));finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(a26.this, a25.class));
        finish();
    }
}
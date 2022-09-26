package com.example.quizapp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.data.DbHandler;

import java.text.SimpleDateFormat;
import java.util.Date;


public class a25 extends AppCompatActivity {
    private Button login;
    private Button No;
    private EditText hour;
    private EditText minute;String ans;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q25);
        hour=findViewById(R.id.hour);
        minute=findViewById(R.id.min);
        String date="1";
        No=findViewById(R.id.No);
        login=findViewById(R.id.Login);
        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans="No";
                String h=hour.getText().toString();
                String m=minute.getText().toString();
                if(TextUtils.isEmpty(h) || TextUtils.isEmpty(m)){
                    Toast.makeText(a25.this, "No selected", Toast.LENGTH_SHORT).show();
                    DbHandler db=new DbHandler(a25.this);
                    db.update_ans25(date,ans);
                    Toast.makeText(a25.this, ans, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(a25.this,a26.class));
                }
                else{
                    DbHandler db=new DbHandler(a25.this);
                    db.update_ans25(date,ans);
                    Toast.makeText(a25.this, ans, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(a25.this,a26.class));
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String h=hour.getText().toString();
                String m=minute.getText().toString();
                if(TextUtils.isEmpty(h )|| TextUtils.isEmpty(m)){
                    Toast.makeText(a25.this, "Please enter hour and minute or select no", Toast.LENGTH_SHORT).show();
                }
                ans=h+":"+m;
                DbHandler db=new DbHandler(a25.this);
                db.update_ans25(date,ans);
                Toast.makeText(a25.this, ans, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(a25.this,a26.class));
            }
        });
    }
}
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

public class a11 extends AppCompatActivity {
    private Button login;
    private EditText hour;
    private Button no;
    private EditText minute;String ans;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q11);
        login=findViewById(R.id.Login);
        hour=findViewById(R.id.hour);
        minute=findViewById(R.id.min);
        no=findViewById(R.id.No);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String h = hour.getText().toString();
                String m = minute.getText().toString();
                if (TextUtils.isEmpty(m) || TextUtils.isEmpty(h)) {
                    Toast.makeText(a11.this, "No selected", Toast.LENGTH_SHORT).show();
                }
                ans="No";
                Toast.makeText(a11.this, "No selected", Toast.LENGTH_SHORT).show();
                DbHandler db=new DbHandler(a11.this);
                db.update_ans11(date,ans);
                startActivity(new Intent(a11.this, a12.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String h = hour.getText().toString();
                String m = minute.getText().toString();
                if (TextUtils.isEmpty(m)) {
                    Toast.makeText(a11.this, "Please enter some minute or select no", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(h)){
                    ans=m;
                    DbHandler db=new DbHandler(a11.this);
                    db.update_ans11(date,ans);
                    Toast.makeText(a11.this, ans, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(a11.this,a12.class));
                }

                else {
                    ans = h + ":" + m;
                    DbHandler db=new DbHandler(a11.this);
                    db.update_ans11(date,ans);
                    Toast.makeText(a11.this, ans, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(a11.this, a12.class));
                }
            }
        });
    }
}
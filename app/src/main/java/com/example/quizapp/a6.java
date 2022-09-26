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

public class a6 extends AppCompatActivity {
    private Button login;
    private Button no;
    private EditText password;String ans;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q6);
        no=findViewById(R.id.NO);
        login=findViewById(R.id.Login);
        password=findViewById(R.id.Password);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans="no";
                if(TextUtils.isEmpty(password.getText().toString()))
                    Toast.makeText(a6.this, "No selected", Toast.LENGTH_SHORT).show();

                DbHandler db=new DbHandler(a6.this);
                db.update_ans6(date,ans);
                Toast.makeText(a6.this, ans, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(a6.this,a7.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans=password.getText().toString();
                if(TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(a6.this, "Pls enter something or select no instead", Toast.LENGTH_SHORT).show();

                }
                else{
                    DbHandler db=new DbHandler(a6.this);
                    db.update_ans6(date,ans);
                    Toast.makeText(a6.this, ans, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(a6.this,a7.class));
                }
            }
        });
    }
}
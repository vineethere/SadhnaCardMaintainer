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

public class a7 extends AppCompatActivity {
    private Button login;
    private EditText password;
    private Button zero;String ans;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q7);
        login=findViewById(R.id.login);
        password=findViewById(R.id.Password);
        zero=findViewById(R.id.zero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans="zero";
                if(TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(a7.this, "Zero selected", Toast.LENGTH_SHORT).show();
                }
                DbHandler db=new DbHandler(a7.this);
                db.update_ans7(date,ans);
                Toast.makeText(a7.this, ans, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(a7.this, a8.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(a7.this, "Enter something or click 0 instead", Toast.LENGTH_SHORT).show();
                } else {
                    ans=password.getText().toString();
                    DbHandler db=new DbHandler(a7.this);
                    db.update_ans7(date,ans);
                    Toast.makeText(a7.this, ans, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(a7.this, a8.class));
                }
            }
        });
    }
}
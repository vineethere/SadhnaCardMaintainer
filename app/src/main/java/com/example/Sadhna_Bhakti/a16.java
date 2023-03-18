package com.example.Sadhna_Bhakti;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Sadhna_Bhakti.data.DbHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

public class a16 extends AppCompatActivity {
    private Button login;
    private EditText password;String ans;
    private Button no;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q16);
        no=findViewById(R.id.NO);
        login=findViewById(R.id.Login);
        password=findViewById(R.id.Password);

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(TextUtils.isEmpty(password.getText().toString())){
                   Toast.makeText(a16.this, "No selected", Toast.LENGTH_SHORT).show();
               }
               ans="no";
                DbHandler db=new DbHandler(a16.this);
                db.update_ans16(date,ans);
//                Toast.makeText(a16.this, ans, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(a16.this,a17.class));finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans=password.getText().toString();
                if(TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(a16.this, "Pls enter something or select no instead", Toast.LENGTH_SHORT).show();
                }
                else{
                    DbHandler db=new DbHandler(a16.this);
                    db.update_ans16(date,ans);
                    Toast.makeText(a16.this, ans, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(a16.this,a17.class));finish();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(a16.this, a15.class));
        finish();
    }
}
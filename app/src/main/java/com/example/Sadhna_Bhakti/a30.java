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

public class a30 extends AppCompatActivity {
    private Button login;
    private Button fifty;
    private EditText password;
    String ans;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q30);
        login=findViewById(R.id.Login);
        password=findViewById(R.id.Password);
        fifty=findViewById(R.id.fifty);
        fifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ans="50%";
                DbHandler db=new DbHandler(a30.this);
                db.update_ans30(date,ans);
                Toast.makeText(a30.this, ans, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(a30.this,index.class));
                finish();
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(a30.this, "Enter something", Toast.LENGTH_SHORT).show();
                }
                else {
                    ans=password.getText().toString();
                    DbHandler db=new DbHandler(a30.this);
                    db.update_ans30(date,ans);
                    Toast.makeText(a30.this, ans, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(a30.this,index.class));finish();
                }
            }

        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(a30.this, a29.class));
        finish();
    }
}
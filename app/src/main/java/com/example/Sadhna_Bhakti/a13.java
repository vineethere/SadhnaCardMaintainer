package com.example.Sadhna_Bhakti;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Sadhna_Bhakti.data.DbHandler;

import java.text.SimpleDateFormat;
import java.util.Date;


public class a13 extends AppCompatActivity {
    private Button login;
    private EditText password;
    private Button no;String ans="";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q13);
        no=findViewById(R.id.NO);
        login=findViewById(R.id.Login);
        password=findViewById(R.id.Password);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans="No";
                if(TextUtils.isEmpty(password.getText().toString())){
                    Log.d("reg","fe");
                }
                DbHandler db=new DbHandler(a13.this);
                db.update_ans13(date,ans);
                startActivity(new Intent(a13.this, a14.class));finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                ans = password.getText().toString();
                if (TextUtils.isEmpty(ans)) {
                    Toast.makeText(a13.this, "Pls enter something", Toast.LENGTH_SHORT).show();
                }
                else {
                    DbHandler db = new DbHandler(a13.this);
                    db.update_ans13(date, ans);
                    startActivity(new Intent(a13.this, a14.class));finish();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(a13.this, a12.class));
        finish();
    }
}
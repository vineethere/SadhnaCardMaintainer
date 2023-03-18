package com.example.Sadhna_Bhakti;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Sadhna_Bhakti.data.DbHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

public class a14 extends AppCompatActivity {
    private Button yes;
    String ans;
    private Button no;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q14);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans="yes";
                DbHandler db=new DbHandler(a14.this);
                db.update_ans14(date,ans);
                Toast.makeText(a14.this, ans, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(a14.this,a15.class));finish();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans="no";
                DbHandler db=new DbHandler(a14.this);
                db.update_ans14(date,ans);
                Toast.makeText(a14.this, ans, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(a14.this,a15.class));finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(a14.this, a13.class));
        finish();
    }
}
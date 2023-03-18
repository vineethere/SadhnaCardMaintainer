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

public class a19 extends AppCompatActivity {
    private Button login;
    private EditText time;
    private Button no;
    String ans="-1";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q19);

        login=findViewById(R.id.Login);
        time=findViewById(R.id.Password);
        no=findViewById(R.id.NO);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans="no";
                if (TextUtils.isEmpty(time.getText().toString())) {
                    Log.d("this","this ");
                }
                DbHandler db=new DbHandler(a19.this);
                db.update_ans19(date,ans);
                Log.d("a10",ans);
                Toast.makeText(a19.this, ans, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(a19.this, a20.class));finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String h = time.getText().toString();
                if (TextUtils.isEmpty(h)) {
                    Toast.makeText(a19.this, "Please enter  something or select no", Toast.LENGTH_SHORT).show();
                }
                else{
                    ans = h;
                    DbHandler db=new DbHandler(a19.this);
                    db.update_ans19(date,ans);
                    Toast.makeText(a19.this, ans, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(a19.this, a20.class));finish();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(a19.this, a18.class));
        finish();
    }
}
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

public class a9 extends AppCompatActivity {
    private Button login;
    private EditText password;
    String ans="-1";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q9);
        login=findViewById(R.id.Login);
        password=findViewById(R.id.Password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(a9.this, "Enter something", Toast.LENGTH_SHORT).show();
                }
                else {
                    ans=password.getText().toString();
                    Log.d("a9",ans);
                    DbHandler db=new DbHandler(a9.this);
                    db.update_ans9(date,ans);
                    Toast.makeText(a9.this, ans, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(a9.this, a10.class));finish();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(a9.this, a8.class));
        finish();
    }
}
package com.example.Sadhna_Bhakti;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.Sadhna_Bhakti.data.DbHandler;
import com.example.Sadhna_Bhakti.entry.row;

import java.text.SimpleDateFormat;
import java.util.Date;

public class index extends AppCompatActivity {
    private Button pdf;
    private Button alarm;
    private Button word;
    private Button fill;
    private Button quit;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);


        alarm= (Button) findViewById(R.id.alarm);
        pdf=findViewById(R.id.pdf);
        quit=findViewById(R.id.quit);
        word=findViewById(R.id.word);
        fill=findViewById(R.id.fill);

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHandler db=new DbHandler(index.this);
                row r=new row();
                r.setDate(date);
                r.setQues1(" - ");  r.setQues2(" - ");   r.setQues3(" - ");  r.setQues4(" - ");   r.setQues5(" - ");  r.setQues6(" - ");   r.setQues7(" - ");  r.setQues8(" - ");
                r.setQues9(" - ");  r.setQues10(" - ");   r.setQues11(" - ");  r.setQues12(" - ");   r.setQues13(" - ");  r.setQues14(" - ");   r.setQues15(" - ");  r.setQues16(" - ");
                r.setQues17(" - ");  r.setQues18(" - ");   r.setQues19(" - ");  r.setQues20(" - ");     r.setQues22(" - ");   r.setQues23(" - ");  r.setQues24(" - ");
                r.setQues25(" - ");  r.setQues26(" - ");   r.setQues27(" - ");  r.setQues28(" - ");   r.setQues29(" - ");  r.setQues30(" - ");

                db.addrow(r);
                startActivity(new Intent(index.this,a1.class));finish();
            }
        });
        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(index.this,pdfviewer.class));finish();
            }
        });
        word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(index.this,wordGenerator.class));finish();
            }
        });
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(index.this,alarm.class));
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }

    }
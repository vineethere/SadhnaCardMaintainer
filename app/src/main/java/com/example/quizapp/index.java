package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.data.DbHandler;
import com.example.quizapp.entry.row;

import java.text.SimpleDateFormat;
import java.util.Date;

public class index extends AppCompatActivity {
    private Button pdf;
    private Button word;
    private Button quit;
    private Button fill;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        pdf=findViewById(R.id.pdf);
        word=findViewById(R.id.word);
        quit=findViewById(R.id.quit);
        fill=findViewById(R.id.fill);
        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHandler db=new DbHandler(index.this);
                row r=new row();
                r.setDate(date);
                r.setQues1(" - ");  r.setQues2(" - ");   r.setQues3(" - ");  r.setQues4(" - ");   r.setQues5(" - ");  r.setQues6(" - ");   r.setQues7(" - ");  r.setQues8(" - ");
                r.setQues9(" - ");  r.setQues10(" - ");   r.setQues11(" - ");  r.setQues12(" - ");   r.setQues13(" - ");  r.setQues14(" - ");   r.setQues15(" - ");  r.setQues16(" - ");
                r.setQues17(" - ");  r.setQues18(" - ");   r.setQues19(" - ");  r.setQues20(" - ");   r.setQues21(" - ");  r.setQues22(" - ");   r.setQues23(" - ");  r.setQues24(" - ");
                r.setQues25(" - ");  r.setQues26(" - ");   r.setQues27(" - ");  r.setQues28(" - ");   r.setQues29(" - ");  r.setQues30(" - ");

                db.addrow(r);
                startActivity(new Intent(index.this,a1.class));
            }
        });
        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(index.this,pdfviewer.class));
            }
        });
        word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(index.this,wordGenerator.class));
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
            }
        });

    }
}
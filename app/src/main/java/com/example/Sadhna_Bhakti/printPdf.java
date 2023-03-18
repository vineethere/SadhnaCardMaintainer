package com.example.Sadhna_Bhakti;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;

import androidx.core.app.ActivityCompat;

import com.example.Sadhna_Bhakti.entry.row;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class printPdf {
    String q1="What time did you go to sleep last night?",
            q2="What time did you wake up in the morning?",
            q3="How long did you take rest in day time?",
            q4="What time did you take bath in morning?",
            q5="Did you attend mangal aarti and at what time?",
            q6="Where did you attend mangal aarti?",
            q7="How many rounds of japa you did before mangal aarti?",
            q8="What time you completed 16 rounds?",
            q9="Total rounds you did before going out or work in the morning?",
            q10="How long did you listen to your Guru Maharaja's/other's class?",
            q11="How long did you listen to Srila Prabhupada's class?",
            q12="How long did you listen to kirtan while doing daily activities?",
            q13="How many books you distributed today?",
            q14="Did you do Harinam in public place today?",
            q15="Did you distributed prasadam to public  or in mealtime?",
            q16="What seva you did today in temple/ashram/center/other place?",
            q17="Did you read Srila Prabhupada books today? how much time?",
            q18="Did you meditate on shloka, bhajan or what you heard in class today?",
            q19="How long you read Krishna book in night?",
            q20="Did you associate with other devotees today?",

            q22="How long did you chant with other devotees?",
            q23="Did you eat prasadam cooked and offered by devotees?",
            q24="Did you eat anything from outside not cooked by devotees?",
            q25="How long did you watch TV/read newspaper/Browsing the internet?",
            q26="Did you wear Vaishnava clothes at home?",
            q27="Did you wear Vaishnava clothes outside?",
            q28="Did you wear Vaishnava clothes at work?",
            q29="Do you always use tilak whenever faded/washed ?",
            q30="What percentage of income did you sacrifice for preaching mission?";
    String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a22,a23,a24,a25,a26,a27,a28,a29,a30;

    public printPdf(row r) {

        this.a1=r.getQues1();this.a2=r.getQues2();this.a3=r.getQues3();this.a4=r.getQues4();
        this.a5=r.getQues5();this.a6=r.getQues6();this.a7=r.getQues7();this.a8=r.getQues8();
        this.a9=r.getQues9();this.a10=r.getQues10();
        this.a11=r.getQues11();this.a12=r.getQues12();this.a13=r.getQues13();this.a14=r.getQues14();
        this.a15=r.getQues15();this.a16=r.getQues16();this.a17=r.getQues17();this.a18=r.getQues18();
        this.a19=r.getQues19();this.a20=r.getQues20();
        this.a25=r.getQues25();this.a26=r.getQues26();this.a27=r.getQues27();this.a28=r.getQues28();
        this.a29=r.getQues29();this.a30=r.getQues30();
    }


    public void getPdf(String date, Context context) throws FileNotFoundException {
        ActivityCompat.requestPermissions ((Activity) context,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.JELLY_BEAN){
            print(date);
        }
    }

    private void print(String date) {
        String pdfPath=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file=new File(pdfPath,"Report_"+date+".pdf");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Document document=new Document();
        try {
            PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        document.open();

        float[] columnwidth1 ={400f,100f};
        PdfPTable table=new PdfPTable(columnwidth1);
        table.addCell("Question");
        table.addCell("Answer");
        if(a1==null){
            try {
                document.add(table);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            document.close();
        }else {
            table.addCell(q1);
            table.addCell(a1);
            table.addCell(q2);
            table.addCell(a2);
            table.addCell(q3);
            table.addCell(a3);
            table.addCell(q4);
            table.addCell(a4);
            table.addCell(q5);
            table.addCell(a5);
            table.addCell(q6);
            table.addCell(a6);
            table.addCell(q7);
            table.addCell(a7);
            table.addCell(q8);
            table.addCell(a8);
            table.addCell(q9);
            table.addCell(a9);
            table.addCell(q10);
            table.addCell(a10);


            table.addCell(q11);
            table.addCell(a11);
            table.addCell(q12);
            table.addCell(a12);
            table.addCell(q13);
            table.addCell(a13);
            table.addCell(q14);
            table.addCell(a14);
            table.addCell(q15);
            table.addCell(a15);
            table.addCell(q16);
            table.addCell(a16);
            table.addCell(q17);
            table.addCell(a17);
            table.addCell(q18);
            table.addCell(a18);
            table.addCell(q19);
            table.addCell(a19);
            table.addCell(q20);
            table.addCell(a20);
            table.addCell(q22);
            table.addCell(a22);
            table.addCell(q23);
            table.addCell(a23);
            table.addCell(q24);
            table.addCell(a24);
            table.addCell(q25);
            table.addCell(a25);
            table.addCell(q26);
            table.addCell(a26);
            table.addCell(q27);
            table.addCell(a27);
            table.addCell(q28);
            table.addCell(a28);
            table.addCell(q29);
            table.addCell(a29);
            table.addCell(q30);
            table.addCell(a30);


            try {
                document.add(table);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            document.close();
        }
    }

}
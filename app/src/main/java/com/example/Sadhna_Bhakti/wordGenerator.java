package com.example.Sadhna_Bhakti;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import com.example.Sadhna_Bhakti.data.DbHandler;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class wordGenerator extends AppCompatActivity {
    private Button generate;
    private TextView sdate;
    private TextView edate;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String[] PERMISSION_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            WRITE_EXTERNAL_STORAGE,
    };
    String date1,date2;
    Date startDate,endDate;
    private DatePickerDialog.OnDateSetListener setListner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_generator);
        sdate=findViewById(R.id.sdate);
        edate=findViewById(R.id.edate);
        generate=findViewById(R.id.generate);
        Calendar calendar=Calendar.getInstance();
        final int day=calendar.get(Calendar.DAY_OF_MONTH);    
        final int month=calendar.get(Calendar.MONTH);
        final int year=calendar.get(Calendar.YEAR);
        sdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(wordGenerator.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
//                        date1=day+"-"+month+"-"+year;
                        date1=year+"-";
                        if(month<10){
                            date1+="0"+month;
                        }
                        else{
                            date1+=month;
                        }
                        date1+="-";
                        if(day<10){
                            date1+="0"+day;
                        }
                        else{
                            date1+=day;
                        }
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                           startDate = formatter.parse(date1);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        sdate.setText(date1);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        edate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(wordGenerator.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        date2=year+"-";
                        if(month<10){
                            date2+="0"+month;
                        }
                        else{
                            date2+=month;
                        }
                        date2+="-";
                        if(day<10){
                            date2+="0"+day;
                        }
                        else{
                            date2+=day;
                        }

                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                          endDate = formatter.parse(date2);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        edate.setText(date2);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        generate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v){
                int permission = ActivityCompat.checkSelfPermission(wordGenerator.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (permission != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(wordGenerator.this, "Storage permissions not granted", Toast.LENGTH_SHORT).show();
                    ActivityCompat.requestPermissions(wordGenerator.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate startDate = LocalDate.parse(date1,formatter);
                LocalDate endDate = LocalDate.parse(date2,formatter);
                if(endDate.isBefore(startDate))
                {
                    Toast.makeText(wordGenerator.this, "LOL", Toast.LENGTH_SHORT).show();
                }
                LocalDate itr = null;

                 //main code
                DbHandler dbHandler = new DbHandler(wordGenerator.this);
                SQLiteDatabase db = dbHandler.getReadableDatabase();
                ArrayList<ArrayList<String>> arr=new ArrayList<>();
                for (itr = startDate; !itr.isAfter(endDate) ; itr = itr.plusDays(1))
                {
                    ArrayList<String> temp = dbHandler.getEntry(String.valueOf(itr));
                    if(temp.size()==0)continue;
                    arr.add(temp);
                }
                System.out.println(arr);
                //transposing
                ArrayList<ArrayList<String>> arr1 = new ArrayList<>();//list of list to hold transpose

                final int firstListSize = arr.get(0).size();
                System.out.println(firstListSize);
                for (int i = 0; i < firstListSize; i++) {
                    ArrayList<String> tempList = new ArrayList<>();//Temp list to hold each transposed row which was column initially

                    for (ArrayList<String> row : arr) { // iterate outer list to get sublist each time in the iteration
                        tempList.add(row.get(i));//take sublist element at ith position each time and add it to temp list
                    }

                    arr1.add(tempList);//each transposed list is added to transposedList
                }


                HSSFWorkbook hssfworkbook = new HSSFWorkbook();
                HSSFSheet sheet = hssfworkbook.createSheet();
                int count=0;
                String[] ques ={
                        "Date",
                        "What time did you go to sleep last night?",
                        "What time did you wake up in the morning?",
                        "How long did you take rest in day time?",
                        "What time did you take bath in morning?",
                        "Did you attend mangal aarti and at what time?",
                        "Where did you attend mangal aarti?",
                        "How many rounds of japa you did before mangal aarti?",
                        "What time you completed 16 rounds?",
                        "Total rounds you did before going out or work in the morning?",
                        "How long did you listen to your Guru Maharaja's/other's class?",
                        "How long did you listen to Srila Prabhupada's class?",
                        "How long did you listen to kirtan while doing daily activities?",
                        "How many books you distributed today?",
                        "Did you do Harinam in public place today?",
                        "Did you distributed prasadam to public  or in mealtime?",
                        "What seva you did today in temple/ashram/center/other place?",
                        "Did you read Srila Prabhupada books today? how much time?",
                        "Did you meditate on shloka, bhajan or what you heard in class today?",
                        "How long you read Krishna book in night?",
                        "Did you associate with other devotees today?",
                        //-----------------------------------
                        "How long did you chant with other devotees?",
                        "Did you eat prasadam cooked and offered by devotees?",
                        "Did you eat anything from outside not cooked by devotees?",
                        "How long did you watch TV/read newspaper/Browsing the internet?",
                        "Did you wear Vaishnava clothes at home?",
                        "Did you wear Vaishnava clothes outside?",
                        "Did you wear Vaishnava clothes at work?",
                        "Do you always use tilak whenever faded/washed ?",
                        "What percentage of income did you sacrifice for preaching mission?"};

                for(int i=0;i<arr1.size();i++){
                    System.out.println(arr1.size());
                    HSSFRow row = sheet.createRow(i);
                    HSSFCell c=row.createCell(0);
                    c.setCellValue(ques[count++]);
                    for (int j = 0; j < arr1.get(i).size(); j++) {
                        HSSFCell cell = row.createCell(j+1);
                        cell.setCellValue(arr1.get(i).get(j));
                    }
                }

                String file= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
                File filePath=new File(file,"Report_"+date1+"-"+date2+".xls");
                try {
                    FileOutputStream outputStream=new FileOutputStream(filePath);
                    hssfworkbook.write(outputStream);
                    if (outputStream!=null){
                        outputStream.flush();
                        outputStream.close();
                    }
                }
                catch (IOException e){
                    e.printStackTrace();
                }

                show("Report_"+date1+"-"+date2+".xls");
            }

            private void show(String temp) {
                // Get the File location and file name.
                String filepath= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
                File file=new File(filepath,temp);
                // Get the URI Path of file.
                Uri uriPdfPath = FileProvider.getUriForFile(wordGenerator.this,
                        getApplicationContext().getPackageName() + ".provider", file);
                Log.d("pdfPath", "" + uriPdfPath);
                // Start Intent to View PDF from the Installed Applications.
                Intent pdfOpenIntent = new Intent(Intent.ACTION_VIEW);
                pdfOpenIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                pdfOpenIntent.setClipData(ClipData.newRawUri("", uriPdfPath));
                pdfOpenIntent.setDataAndType(uriPdfPath, "application/ms-excel");
                pdfOpenIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

                try {
                    startActivity(pdfOpenIntent);
                } catch (ActivityNotFoundException activityNotFoundException) {
                    Toast.makeText(wordGenerator.this, "There is no app to load corresponding file", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(wordGenerator.this, index.class));
        finish();
    }
}
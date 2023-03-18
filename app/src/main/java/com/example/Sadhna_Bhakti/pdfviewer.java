package com.example.quizapp;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.os.Build.VERSION.SDK_INT;
import static android.provider.Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
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

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import com.example.quizapp.data.DbHandler;
import com.example.quizapp.entry.row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class pdfviewer extends AppCompatActivity {
    private Button create;
    private String date=NULL;
    Date sdate;
    private TextView selectdate;
    Calendar calendar = Calendar.getInstance();
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final int month = calendar.get(Calendar.MONTH);
    final int year = calendar.get(Calendar.YEAR);
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String[] PERMISSION_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            WRITE_EXTERNAL_STORAGE,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);
        verifyStoragePermission(this);
        create = findViewById(R.id.create);
        selectdate = findViewById(R.id.select);
        selectdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(pdfviewer.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        date = year + "-";
                        if (month < 10) {
                            date += "0" + month;
                        } else {
                            date += month;
                        }
                        date += "-";
                        if (day < 10) {
                            date += "0" + day;
                        } else {
                            date += day;
                        }
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            sdate = formatter.parse(date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        selectdate.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(date!=NULL)
                dowork();
                else
                    Toast.makeText(pdfviewer.this, "Please enter a valid date", Toast.LENGTH_SHORT).show();
            }

            private void dowork() {
                DbHandler db = new DbHandler(pdfviewer.this);
                row r = db.getrow(date);
                printPdf p = new printPdf(r);
                try {
                    p.getPdf(date, pdfviewer.this);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                openPdf(date);
            }
        });
    }

    public void verifyStoragePermission(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, WRITE_EXTERNAL_STORAGE);

        // Surrounded with if statement for Android R to get access of complete file.
        if (SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager() && permission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        activity,
                        PERMISSION_STORAGE,
                        REQUEST_EXTERNAL_STORAGE);

                // Abruptly we will ask for permission once the application is launched for sake demo.
                Intent intent = new Intent();
                intent.setAction(ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                Uri uri = Uri.fromParts("package", this.getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            }
        }
    }


    private void openPdf(String date) {
        // Get the File location and file name.
        String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new File(pdfPath, "Report_" + date + ".pdf");
        Log.d("pdfFIle", "" + file);

        // Get the URI Path of file.
        Uri uriPdfPath = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() +
                ".provider", file);
        Log.d("pdfPath", "" + uriPdfPath);

        // Start Intent to View PDF from the Installed Applications.
        Intent pdfOpenIntent = new Intent(Intent.ACTION_VIEW);
        pdfOpenIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        pdfOpenIntent.setClipData(ClipData.newRawUri("", uriPdfPath));
        pdfOpenIntent.setDataAndType(uriPdfPath, "application/pdf");
        pdfOpenIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        try {
            startActivity(pdfOpenIntent);
        } catch (ActivityNotFoundException activityNotFoundException) {
            Toast.makeText(this, "There is no app to load corresponding PDF", Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(pdfviewer.this, index.class));
        finish();
    }
}
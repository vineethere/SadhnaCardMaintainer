package com.example.quizapp;


import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Boolean isIsAlarm=prefs.getBoolean("isalarm",false);

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                if (isIsAlarm) {
                    NotificationChannel();
                    int h =Integer.valueOf(prefs.getInt("hour", -1));
                    int m = Integer.valueOf(prefs.getInt("min", -1));


                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY,h);
                    calendar.set(Calendar.MINUTE,m);
                    calendar.set(Calendar.SECOND, 00);

                    if (Calendar.getInstance().after(calendar)) {
                        calendar.add(Calendar.DAY_OF_MONTH, 1);
                    }
                    Intent intent = new Intent(MainActivity.this, MemoBroadcast.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                    }
                }
            }
        };

                Runnable runnable3 = new Runnable(){
                    @Override
                    public void run() {
                        Intent intent=new Intent(MainActivity.this,index.class);
                        startActivity(intent);
                        finish();
                    }
                };
                Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(runnable2, 1000);
                handler.postDelayed(runnable3, 5000);
      }

   private void NotificationChannel() {
   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
       CharSequence name = "Report alert";
       String description = "Report Alert";
       int importance = NotificationManager.IMPORTANCE_DEFAULT;
       NotificationChannel channel = new NotificationChannel("Notification", name, importance);
       channel.setDescription(description);

       NotificationManager notificationManager = getSystemService(NotificationManager.class);
       notificationManager.createNotificationChannel(channel);
        }
    }
}
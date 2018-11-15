package com.debuggersstudio.bid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Button grpbtn;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       
       viewPager = (ViewPager)findViewById(R.id.viewPager);
        ViewpagerAdpter viewpagerAdpter = new ViewpagerAdpter(this);
        viewPager.setAdapter(viewpagerAdpter);
        Timer timer = new Timer( );
        timer.scheduleAtFixedRate(new MyTimer(),2000,4000);
        //grpbtn = (Button)findViewById(R.id.grap);


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,11);
        calendar.set(Calendar.MINUTE, 32);
        calendar.set(Calendar.SECOND, 10);

        //Intent intent = new Intent(load.this, AlarmReceiver.class);

        Intent intent = new Intent(getApplicationContext(), Notification_receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);



    }

   public void grap(View view){

        Intent intent = new Intent(MainActivity.this,GenerateGrap.class);
        startActivity(intent);
    }

    public void gas(View view){

        Intent intent = new Intent(MainActivity.this,GasActivity.class);
        startActivity(intent);
    }
    public void Biddut(View view){

        Intent intent = new Intent(MainActivity.this,biddut.class);
        startActivity(intent);
    }
    public void Panibtn(View view){

        Intent intent = new Intent(MainActivity.this,Pani.class);
        startActivity(intent);
    }
    public void control(View view){

        Intent intent = new Intent(MainActivity.this,controller.class);
        startActivity(intent);
    }

    public void video(View view){

        Intent intent = new Intent(MainActivity.this,video.class);
        startActivity(intent);
    }




    public  class MyTimer extends TimerTask{

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()==0)
                    viewPager.setCurrentItem(1);
                    else if (viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);

                    }
                    else if(viewPager.getCurrentItem()==2){
                        viewPager.setCurrentItem(3);
                    }
                    else{
                        viewPager.setCurrentItem(0);
                    }
                }
            });

        }
    }
}

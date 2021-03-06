package com.debuggersstudio.bid;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;

/**
 * Created by ib-internetbasic on 4/18/17.
 */

public class Notification_receiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2600);
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent repeating_intent = new Intent(context,controller.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
          .setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
        .setContentTitle("Save Energy")
                .setContentText("Turn off all switch you don't need")
                .setAutoCancel(true);



        notificationManager.notify(100,builder.build());

    }
}

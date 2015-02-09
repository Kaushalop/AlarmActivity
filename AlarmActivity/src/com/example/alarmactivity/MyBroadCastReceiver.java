package com.example.alarmactivity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver {
  
	NotificationManager nm;
	  static final int uni=12309;
	  
  @SuppressLint("ServiceCast") 
  public void onReceive(Context context, Intent intent) {
	  

	  nm=(NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
		nm.cancel(uni);
    Toast.makeText(context, "Don't panik but your time is up!!!!.",
        Toast.LENGTH_LONG).show();
    // Vibrate the mobile phone
    Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    vibrator.vibrate(2000);
    noti(context);
   // Intent i = new Intent(context,StatusBar.class);
    //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	//context.startActivity(i);
  }

private void noti(Context context) {
	// TODO Auto-generated method stub
	Intent intent = new Intent(context,MyBroadCastReceiver.class);
	PendingIntent pi=PendingIntent.getActivity(context,0,intent,0);
	String body="Hi";
	String title="Two";
	Notification n=new Notification(R.drawable.ic_launcher,"Reminder",System.currentTimeMillis());
    n.setLatestEventInfo(context, "Hi", "Reminder", pi );
    n.defaults=Notification.DEFAULT_ALL;
    nm.notify(uni,n);
	//finish();
}
} 

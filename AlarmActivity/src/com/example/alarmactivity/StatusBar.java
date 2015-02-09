package com.example.alarmactivity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StatusBar extends Activity implements OnClickListener{
	NotificationManager nm;
	  static final int uni=12309;
	protected void onCreateView(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.statusbar);
		Bundle extras = getIntent().getExtras();
		Button stat=(Button)findViewById(R.id.button1);
		stat.setOnClickListener(this);
		nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		nm.cancel(uni);
	}
	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this,StatusBar.class);
		PendingIntent pi=PendingIntent.getActivity(this,0,intent,0);
		String body="One";
		String title="Two";
		Notification n=new Notification(R.drawable.ic_launcher,"Hi",System.currentTimeMillis());
	    n.setLatestEventInfo(this, "whatsup", "Hi", pi );
	    n.defaults=Notification.DEFAULT_ALL;
	    nm.notify(uni,n);
		finish();
	}
	

}

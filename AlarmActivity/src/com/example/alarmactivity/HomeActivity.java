package com.example.alarmactivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {

	TextView t;
	EditText sub;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/custom.ttf");
		t=(TextView)findViewById(R.id.textView1);
		sub=(EditText)findViewById(R.id.input);
		t.setTypeface(custom_font);
		
	}
	public void startAlert(View view) {
	    EditText text = (EditText) findViewById(R.id.time);
	    int i = Integer.parseInt(text.getText().toString());
	    Intent intent = new Intent(this, MyBroadCastReceiver.class);
	    
	   // PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
	    PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, intent,PendingIntent.FLAG_CANCEL_CURRENT);
	    //intent.putExtra("Subject",""+sub.getText().toString());
	    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
	    alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
	        + (i * 1000), pendingIntent);
	    Toast.makeText(this, "Alarm set in " + i + " seconds",
	        Toast.LENGTH_LONG).show();
	  }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_home, menu);
		return true;
	}

}

package com.thosegonzos.hour2app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityB extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layout);
		
		TextView t = (TextView)findViewById(R.id.textView1);
		
		Intent intent = getIntent();
		
		if (intent != null)
		{
			String action = intent.getAction();
	        String type = intent.getType();
	        if (Intent.ACTION_SEND.equals(action) && "text/plain".equals(type)) 
	        {
	               t.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
	        } 
	        else
	        {
	        	Bundle bundle = intent.getBundleExtra("greetingBundle");
	        	String greeting = bundle.getString("greeting");
	        	String message = intent.getStringExtra("message");
	        	Boolean showAll = intent.getBooleanExtra("showAll", false);
	        	int numItems = intent.getIntExtra("numItems", 0);
	    		t.setText("This is Activity B: " + greeting + " " + message + " " + showAll + " " + numItems);
	        }
		}

		Button b = (Button)findViewById(R.id.button1);
		
		b.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v)
			{
				Intent intent = new Intent(ActivityB.this, ActivityA.class);

				
				// intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
								
				startActivity(intent);
			}
		} );
	}
}

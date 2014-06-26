package com.thosegonzos.hour2app;

// import com.thosegonzos.hour2app.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityA extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layout);
		
		TextView t = (TextView)findViewById(R.id.textView1);
		t.setText("This is Activity A");
		Button b = (Button)findViewById(R.id.button1);
		
		b.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent = new Intent(ActivityA.this, ActivityB.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
				Bundle b = new Bundle();
				b.putString("greeting", "Hello");
				intent.putExtra("greetingBundle", b);
				intent.putExtra("message", "World!");
				intent.putExtra("showAll", true);
				intent.putExtra("numItems", 5);
				
				startActivity(intent);
			}
		} );
		
		Button getData = (Button)findViewById(R.id.button2);
		getData.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent = new Intent(ActivityA.this, ActivityC.class);
				startActivityForResult(intent, 0);
			}
		} );
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if (requestCode == 0 && resultCode == Activity.RESULT_OK)
		{
			String enteredData = data.getStringExtra("Data");
			TextView t = (TextView)findViewById(R.id.textView1);
			t.setText(enteredData);
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
}

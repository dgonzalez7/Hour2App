package com.thosegonzos.hour2app;

// import com.thosegonzos.hour2app.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityC extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_c_layout);
		
		TextView t = (TextView)findViewById(R.id.textView1);
		t.setText("This is Activity C");
		
		final EditText e = (EditText)findViewById(R.id.editText1);
		
		Button sendData = (Button)findViewById(R.id.button1);
		Button cancel = (Button)findViewById(R.id.button2);
		
		
		sendData.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent result = new Intent();
				result.putExtra("Data", e.getText().toString());
				setResult(Activity.RESULT_OK, result);
				finish();
			}
		} );
		
		cancel.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v) 
			{
				setResult(Activity.RESULT_CANCELED);
				finish();
			}
		} );
	}
}

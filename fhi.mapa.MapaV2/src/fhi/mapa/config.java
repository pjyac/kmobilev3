package fhi.mapa;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;


public class config extends Activity {
	public static Button btnconf = null;
	public static String database;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 if (android.os.Build.VERSION.SDK_INT > 9) {
		      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		      StrictMode.setThreadPolicy(policy);
		    }
		super.onCreate(savedInstanceState);
		setContentView(R.layout.config);
		
		
		
		btnconf = (Button) findViewById(R.id.btncountry);
		
		btnconf.setOnClickListener(new View.OnClickListener() {
			 
			public void onClick(View arg0) {
				finish();
				Intent intent = new Intent(getApplicationContext(), conf_2.class);
			    startActivity(intent);
			     }
	 
			});
	
	}

	 
}





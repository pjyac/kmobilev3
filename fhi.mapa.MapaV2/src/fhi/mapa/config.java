package fhi.mapa;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;





public class config extends Activity {
	public static Button btnconf = null;
	private static Button btnabout = null;
	private static Button btnok = null;
	public static String database;
	int selectedItem=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 if (android.os.Build.VERSION.SDK_INT > 9) {
		      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		      StrictMode.setThreadPolicy(policy);
		    }
		super.onCreate(savedInstanceState);
		setContentView(R.layout.config);
		
		final Context context = this;
		
		btnconf = (Button) findViewById(R.id.btncountry);
		btnabout= (Button) findViewById(R.id.botonabout);
		
		btnconf.setOnClickListener(new View.OnClickListener() {
			 
			public void onClick(View arg0) {
				finish();
				Intent intent = new Intent(getApplicationContext(), conf_2.class);
			    startActivity(intent);
				
				 
			}
			});
		  
		btnabout.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				
				// custom dialog
				final Dialog dialog = new Dialog(context, R.style.about);
						    
				dialog.setContentView(R.layout.about);
				dialog.setTitle("About K-mobile"); 
				
				// set the custom dialog components - text, image and button
				TextView text = (TextView) dialog.findViewById(R.id.content);
				text.setText("The Kmobile Schools II app allows the user to query specific school data captured with ODK Collect. \n \n" +
						"Select a school using Google Maps and visualize key performance indicators, enrollment, teacher data, facilities, textbooks and more. \n \n");	 
				btnok = (Button) dialog.findViewById(R.id.dialogButtonOK);
				// if button is clicked, close the custom dialog
				btnok.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
	 
				dialog.show();
			  }
			});
	
	}

	 
}





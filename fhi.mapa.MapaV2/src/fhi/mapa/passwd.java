package fhi.mapa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class passwd extends Activity {
  Integer num;
  String pass;
  String passedit;
  public static Button btnconf = null;
  public static EditText password2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 if (android.os.Build.VERSION.SDK_INT > 9) {
		      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		      StrictMode.setThreadPolicy(policy);
		    }
		super.onCreate(savedInstanceState);
		setContentView(R.layout.passwd);
		btnconf = (Button) findViewById(R.id.btnsave);
		password2 = (EditText) findViewById(R.id.password);
		num = conf_2.passwd.toString().length();
		pass = conf_2.passwd+num;
		
		
		
		
		btnconf.setOnClickListener(new View.OnClickListener() {
			 
			public void onClick(View arg0) {
				
				passedit = password2.getText().toString();
				Log.d("password_py", pass);
				Log.d("password_py2", passedit);
				
		if (passedit.equals(pass)){
			finish();
			Intent intent = new Intent(getApplicationContext(), Mapa2.class);
		    startActivity(intent);
		     }
		
		else{
			Toast.makeText(passwd.this, "Incorrect Password", Toast.LENGTH_LONG).show();  
			finish();
				Intent intent = new Intent(getApplicationContext(), conf_2.class);
			    startActivity(intent);
			}     
			}
	 
			});
	}

}

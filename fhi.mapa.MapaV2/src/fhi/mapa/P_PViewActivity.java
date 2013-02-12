package fhi.mapa;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

@SuppressLint("SetJavaScriptEnabled")
public class P_PViewActivity extends Activity {
	private WebView webView;
	private Button btnmap = null;
	private Button btnpho = null;
	private Button btnP_P = null;
	private Button btnPrim = null;
	private Button btnSec = null;
	private Button btnVoc = null;
	private Button btnTert = null;
	private Button btnALP = null;
	public String nivel;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webviewprepri);
		 btnmap = (Button)findViewById(R.id.BtnMap);
		 btnpho = (Button)findViewById(R.id.BtnPho);
		 btnP_P = (Button)findViewById(R.id.Btnident);
		 btnPrim = (Button)findViewById(R.id.BtnPrim);
		 btnSec = (Button)findViewById(R.id.BtnSec);
		 btnVoc = (Button)findViewById(R.id.BtnVoc);
		 btnTert = (Button)findViewById(R.id.BtnTer);
		 btnALP = (Button)findViewById(R.id.BtnAlp);
		webView = (WebView) findViewById(R.id.webview);
		webView.getSettings().setJavaScriptEnabled(true);
		
		String database = conf_2.database;
		 Bundle bundle=getIntent().getExtras();
		 
		//webView.loadUrl("http://www.fhi360guatemala.org/android/php_couchdb.php?cod="+bundle.getString("codigo"));
		webView.loadUrl("http://www.fhi360guatemala.org/android/kenya_ppV2.php?cod="+bundle.getString("codigo")+"&db="+database+"&nivel="+bundle.getString("niv"));
		//Boton Map
		final Context context = this;
		nivel = bundle.getString("niv"); 
		//final Activity activity = this;
		/*webView.setWebChromeClient(new WebChromeClient() {
			   public void onProgressChanged(WebView view, int progress) {
			     // Activities and WebViews measure progress with different scales.
			     // The progress meter will automatically disappear when we reach 100%
				   //activity.setProgress(progress * 1000);
			   }
			 });
			 webView.setWebViewClient(new WebViewClient() {
			  /* public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
			     Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
			   }*/
			 //});
			
			 //webView.loadUrl("http://190.149.206.186:8080/Doc/schoolDJ.jsp?scod="+bundle.getString("codigo"));*/
			 
		btnmap.setOnClickListener(new View.OnClickListener() {
			
			  
			  public void onClick(View arg0) {
				  finish();	     
				  
			  }
	 
			});
		btnpho.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				finish();
				String codigo = MyOverlay.codigo();
			    Intent intent = new Intent(context, PhotoViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    startActivity(intent);
			  }
	 
			});
		btnP_P.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				finish();
				String codigo = MyOverlay.codigo();
			    Intent intent = new Intent(context, WebViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    intent.putExtra("niv", nivel);
			    startActivity(intent);
			  }
	 
			});
		btnPrim.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				finish();
				String codigo = MyOverlay.codigo();
			    Intent intent = new Intent(context, PrimViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    intent.putExtra("niv", nivel);
			    startActivity(intent);
			  }
	 
			});
		btnSec.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				finish();
				String codigo = MyOverlay.codigo();
			    Intent intent = new Intent(context, SecViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    intent.putExtra("niv", nivel);
			    startActivity(intent);
			  }
	 
			});
		btnVoc.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				finish();
				String codigo = MyOverlay.codigo();
			    Intent intent = new Intent(context, VocViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    intent.putExtra("niv", nivel);
			    startActivity(intent);
			  }
	 
			});
		btnTert.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				finish();
				String codigo = MyOverlay.codigo();
			    Intent intent = new Intent(context, TertViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    intent.putExtra("niv", nivel);
			    startActivity(intent);
			  }
	 
			});
		btnALP.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				finish();
				String codigo = MyOverlay.codigo();
			    Intent intent = new Intent(context, ALPViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    intent.putExtra("niv", nivel);
			    startActivity(intent);
			  }
	 
			});
		
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
    	 MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.menu2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
 	   switch (item.getItemId()) {
 	        case R.id.item2:
 	        	finish();
 	        	
 	           Intent intent = new Intent(getApplicationContext(), P_PViewActivity.class);
 	           intent.putExtra("niv", "1");
			    startActivity(intent);
 	           return true;
 	        case R.id.item3:
 	        	finish();
 	        	
 	           Intent intent2 = new Intent(getApplicationContext(), P_PViewActivity.class);
 	           intent2.putExtra("niv", "2");
			    startActivity(intent2);
 	           return true;
 	       case R.id.item4:
	        	finish();
	        	
	           Intent intent3 = new Intent(getApplicationContext(), P_PViewActivity.class);
	           String codigo = MyOverlay.codigo();
	           intent3.putExtra("codigo", codigo);
			    startActivity(intent3);
	           return true;
 	        default:
 	           return super.onOptionsItemSelected(item);
 	    }
 	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	


}


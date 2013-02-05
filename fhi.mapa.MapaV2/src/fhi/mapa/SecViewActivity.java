package fhi.mapa;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

@SuppressLint("SetJavaScriptEnabled")
public class SecViewActivity extends Activity {
	private WebView webView;
	private Button btnmap = null;
	private Button btnpho = null;
	private Button btnP_P = null;
	private Button btnPrim = null;
	private Button btnSec = null;
	private Button btnVoc = null;
	private Button btnTert = null;
	private Button btnALP = null;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webviewsec);
		 btnmap = (Button)findViewById(R.id.BtnMap);
		 btnpho = (Button)findViewById(R.id.BtnPho);
		 btnP_P = (Button)findViewById(R.id.BtnP_P);
		 btnPrim = (Button)findViewById(R.id.BtnPrim);
		 btnSec = (Button)findViewById(R.id.Btnident);
		 btnVoc = (Button)findViewById(R.id.BtnVoc);
		 btnTert = (Button)findViewById(R.id.BtnTer);
		 btnALP = (Button)findViewById(R.id.BtnAlp);
		webView = (WebView) findViewById(R.id.webview);
		webView.getSettings().setJavaScriptEnabled(true);
		
		
		 Bundle bundle=getIntent().getExtras();
		 String database = conf_2.database;
		//webView.loadUrl("http://www.fhi360guatemala.org/android/php_couchdb.php?cod="+bundle.getString("codigo"));
		webView.loadUrl("http://www.fhi360guatemala.org/android/kenya_sec.php?cod="+bundle.getString("codigo")+"&db="+database);
		//Boton Map
		final Context context = this;
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
			    Intent intent = new Intent(context, P_PViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    startActivity(intent);
			  }
	 
			});
		btnPrim.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				finish();
				String codigo = MyOverlay.codigo();
			    Intent intent = new Intent(context, PrimViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    startActivity(intent);
			  }
	 
			});
		btnSec.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				finish();
				String codigo = MyOverlay.codigo();
			    Intent intent = new Intent(context, WebViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    startActivity(intent);
			  }
	 
			});
		btnVoc.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				finish();
				String codigo = MyOverlay.codigo();
			    Intent intent = new Intent(context, VocViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    startActivity(intent);
			  }
	 
			});
		btnTert.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				finish();
				String codigo = MyOverlay.codigo();
			    Intent intent = new Intent(context, TertViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    startActivity(intent);
			  }
	 
			});
		btnALP.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				finish();
				String codigo = MyOverlay.codigo();
			    Intent intent = new Intent(context, ALPViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    startActivity(intent);
			  }
	 
			});
		
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	


}


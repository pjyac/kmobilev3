package fhi.mapa;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
public class PhotoViewActivity  extends Activity  {
	private WebView photoView;
	private Button btnmap = null;
	private Button btnrep = null;
	@SuppressLint("SetJavaScriptEnabled")
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photoview);
		 btnmap = (Button)findViewById(R.id.BtnMap);
		 btnrep = (Button)findViewById(R.id.BtnRep);
		 photoView = (WebView) findViewById(R.id.photoview);
		 photoView.getSettings().setJavaScriptEnabled(true);
		 Bundle bundle=getIntent().getExtras();
		 String database = conf_2.database;
		//photoView.loadUrl("http://www.fhi360guatemala.org/android/php_couchdb_photo.php?cod="+bundle.getString("codigo"));
		photoView.loadUrl("http://www.fhi360guatemala.org/android/kenya_photo.php?cod="+bundle.getString("codigo")+"&db="+database);
		//Boton Map
		final Context context = this;
		btnmap.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
			  finish();
			  }
	 
			});
		
		btnrep.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				  finish();
				String codigo = MyOverlay.codigo();
			    Intent intent = new Intent(context, WebViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    startActivity(intent);
			  }
	 
			});
		
}
}

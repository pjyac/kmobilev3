package fhi.mapa;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import org.w3c.dom.NodeList;
import android.widget.Button;
import android.widget.Toast;

public class Mapa2 extends MapActivity  {
    /** Called when the activity is first created. */
	private MapView mapView;

	/*private static final int latitudeE6 = 19240000;
	private static final int longitudeE6 = -99120000;
	private static final int latitudeE61 = 19250000;
	private static final int longitudeE61 = -99130000;*/
	public static Button btnrep = null;
	public static Button btnpho = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 if (android.os.Build.VERSION.SDK_INT > 9) {
		      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		      StrictMode.setThreadPolicy(policy);
		    }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mapView = (MapView) findViewById(R.id.map_view);       
        mapView.setBuiltInZoomControls(true);
        mapView.setSatellite(true);
        btnrep = (Button)findViewById(R.id.BtnRep);
        btnpho = (Button)findViewById(R.id.BtnPho);
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.ic_launcher );
		MyOverlay itemizedOverlay = new MyOverlay(drawable, mapView);

		String xml = XMLfunctions.getXML();
        Document doc = XMLfunctions.XMLfromString(xml);
                
        int numResults = XMLfunctions.numResults(doc);
        
        if((numResults <= 0)){
        	Toast.makeText(Mapa2.this, "Data Base without information", Toast.LENGTH_LONG).show();  
        	finish();
        	 Intent intent = new Intent(getApplicationContext(), conf_2.class);
			    startActivity(intent);
        }
                
		NodeList nodes = doc.getElementsByTagName("result");
		int lat; 
		int lon;
		String cod, nom;	
		for (int i = 0; i < nodes.getLength(); i++) {							
			
			Element e = (Element)nodes.item(i);
			cod = XMLfunctions.getValue(e, "ident");
			nom = XMLfunctions.getValue(e, "nombre");
			lat = Integer.parseInt(XMLfunctions.getValue(e, "latitud"));
			lon = Integer.parseInt(XMLfunctions.getValue(e, "longitud"));
			GeoPoint point = new GeoPoint(lat, lon);
			OverlayItem overlayitem = new OverlayItem(point,cod,nom);
			itemizedOverlay.addOverlay(overlayitem);
			mapOverlays.add(itemizedOverlay);
			     
			MapController mapController = mapView.getController();
			mapController.animateTo(point);
			mapController.setZoom(9);  
			
			/*map.put("id", XMLfunctions.getValue(e, "ID"));
        	map.put("name", "Naam:" + XMLfunctions.getValue(e, "latitud"));
        	map.put("Score", "Score: " + XMLfunctions.getValue(e, "longitud"));*/
        			
		}		
		/*GeoPoint point = new GeoPoint(latitudeE6, longitudeE6);
		GeoPoint point1 = new GeoPoint(latitudeE61, longitudeE61);
		OverlayItem overlayitem = new OverlayItem(point, "Hola","Ficha Escolar");
		OverlayItem overlayitem2 = new OverlayItem(point1, "Hola2","prueba");
		itemizedOverlay.addOverlay(overlayitem);
		itemizedOverlay.addOverlay(overlayitem2);
		mapOverlays.add(itemizedOverlay);*/
		
		String codigo = MyOverlay.codigo();
		if (codigo == null){
			btnrep.setEnabled(false);
			btnrep.setTextColor(Color.WHITE);
			btnpho.setEnabled(false);
			btnpho.setTextColor(Color.WHITE);
				
		}
		
		
		final Context context = this;
		btnrep.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				String codigo = MyOverlay.codigo();	
			    Intent intent = new Intent(context, WebViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    startActivity(intent);
			  }
	 
			});
		btnpho.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				String codigo = MyOverlay.codigo();
			    Intent intent = new Intent(context, PhotoViewActivity.class);
			    intent.putExtra("codigo", codigo);
			    startActivity(intent);
			  }
	 
			});
		
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
    	 MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	   switch (item.getItemId()) {
    	        case R.id.item1:
    	        	finish();
    	           Intent intent = new Intent(getApplicationContext(), conf_2.class);
   			    startActivity(intent);
    	           return true;
    	        default:
    	           return super.onOptionsItemSelected(item);
    	    }
    	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
}
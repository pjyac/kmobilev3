package fhi.mapa;
import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class conf_2 extends ListActivity {
	public static String database;
	public static String passwd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 if (android.os.Build.VERSION.SDK_INT > 9) {
		      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		      StrictMode.setThreadPolicy(policy);
		    }
		super.onCreate(savedInstanceState);
setContentView(R.layout.listplaceholder);
        
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
      
       
        String xml = XMLfunConf.getXML();
        Document doc = XMLfunConf.XMLfromString(xml);
                
        int numResults = XMLfunConf.numResults(doc);
        if((numResults <= 0)){
        	Toast.makeText(conf_2.this, "Data Base without information", Toast.LENGTH_LONG).show();  
        	finish();
        }
		NodeList nodes = doc.getElementsByTagName("server");
		
		
		for (int i = 0; i < nodes.getLength(); i++) {							
			HashMap<String, String> map = new HashMap<String, String>();	
			
			Element e = (Element)nodes.item(i);
		
			map.put("id", Integer.toString(i));
        	map.put("name", XMLfunConf.getValue(e, "name"));
        	map.put("db", XMLfunConf.getValue(e, "db"));
        	mylist.add(map);			
		}		
       
        ListAdapter adapter = new SimpleAdapter(this, mylist , R.layout.conf_2, 
                        new String[] { "name" }, 
                        new int[] { R.id.item_title });
        
        setListAdapter(adapter);
        
        final ListView lv = getListView();
        lv.setTextFilterEnabled(true);	
        lv.setOnItemClickListener(new OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {        		
        		@SuppressWarnings("unchecked")
				HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);	        		
        		database = o.get("db");  
        		passwd = o.get("name");
        		finish();
				Intent intent = new Intent(getApplicationContext(), passwd.class);
			    startActivity(intent);
			    intent.putExtra("name_db", database);

			}
		});
	}

}

package hk.alanwong.fkupdatenotifier;

import java.io.*;
import java.net.*;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.ListFragment;
import android.view.*;
import android.widget.*;

public class NotifierFragment extends ListFragment {

	public NotifierFragment() {
	}
		
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);	
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		//-----start
		String[] values = null;
		try{
		    URL url = new URL("http://minooch.com/franciscofranco/Nexus4/4.2.2/appfiles/nightly");
		    
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		    urlConnection.setReadTimeout(15000);
		    urlConnection.setConnectTimeout(15000);
		    urlConnection.setUseCaches(false);
		    urlConnection.setDefaultUseCaches(false);
			urlConnection.setRequestMethod("GET");
		    urlConnection.setDoOutput(true);
		    urlConnection.setDoInput(true);
			urlConnection.connect();
	
		    InputStream inpStream = urlConnection.getInputStream();
				
	        values = new String[] { 
					"Latest nightly - r100", "Latest test", "Current installed", inpStream.toString()
			}; 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        //end
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_2, values);
				
		setListAdapter(adapter);		
	}
	
	protected Object getApplicationContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public void onListItemClick(ListView l, View v, int position, long id) {
		// Do something with the data
	}	
	
}
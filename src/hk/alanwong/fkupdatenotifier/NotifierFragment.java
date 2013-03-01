package hk.alanwong.fkupdatenotifier;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.*;
import android.widget.*;

public class NotifierFragment extends ListFragment {

	public NotifierFragment() {
	}
		
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);	
		
		//-----start
		HttpURLConnection urlConnection = null;
	    URL url = new URL("http://minooch.com/franciscofranco/Nexus4/4.2.2/appfiles/nightly");

	    urlConnection = (HttpURLConnection) url.openConnection();
	    urlConnection.setReadTimeout(15000);
	    urlConnection.setConnectTimeout(15000);
	    urlConnection.setUseCaches(false);
	    urlConnection.setDefaultUseCaches(false);

	    try {
			urlConnection.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    urlConnection.setDoOutput(true);
	    urlConnection.setDoInput(true);

	    try {
			urlConnection.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	    InputStream inpStream;
		try {
			inpStream = urlConnection.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        String[] values = new String[] { 
				"Latest nightly - " + inpStream, "Latest test", "Current installed" 
		};
        
        //end
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.two_line_list_item, values);
				
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
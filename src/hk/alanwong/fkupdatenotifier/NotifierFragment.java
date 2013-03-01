package hk.alanwong.fkupdatenotifier;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.*;
import android.widget.*;

public class NotifierFragment extends ListFragment {

	public NotifierFragment() {
	}
		
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String[] values = new String[] { 
				"Latest nightly", "Latest test", "Current installed" 
		};
				
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
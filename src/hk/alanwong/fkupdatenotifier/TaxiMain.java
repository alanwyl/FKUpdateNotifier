//import java.util.ArrayList;
//import java.util.List;
//
//import android.app.ListActivity;
//import android.content.Context;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//public class TaxiMain extends ListActivity {
//    /** Called when the activity is first created. 
//     * @return */
//
//
//    public class TaxiAdapter extends ArrayAdapter<Taxi> {
//        private ArrayList<Taxi> items;
//        
//        //testing new things
//        private int useless = 0;
//        
//        private TaxiViewHolder taxiHolder;
//
//        private class TaxiViewHolder {
//            TextView name;
//            TextView address; 
//        }
//
//        public TaxiAdapter(Context context, int tvResId, ArrayList<Taxi> items) {
//            super(context, tvResId, items);
//            this.items = items;
//        }
//
//        @Override
//        public View getView(int pos, View convertView, ViewGroup parent) {
//            View v = convertView;
//            if (v == null) {
//                LayoutInflater vi = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
//                v = vi.inflate(R.layout.feed_view, null);
//                taxiHolder = new TaxiViewHolder();
//                taxiHolder.name = (TextView)v.findViewById(R.id.taxi_name);
//                taxiHolder.address = (TextView)v.findViewById(R.id.taxi_address);
//                v.setTag(taxiHolder);
//            } else taxiHolder = (TaxiViewHolder)v.getTag(); 
//
//            Taxi taxi = items.get(pos);
//
//            if (taxi != null) {
//                taxiHolder.name.setText(taxi.getName());
//                taxiHolder.address.setText(taxi.getAddress());
//            }
//
//            return v;
//        }
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//        String[] taxiNames = getResources().getStringArray(R.array.taxi_name_array);
//        String[] taxiAddresses = getResources().getStringArray(R.array.taxi_address_array);
//
//        ArrayList<Taxi> taxiList = new ArrayList<Taxi>();
//
//        for (int i = 0; i < taxiNames.length; i++) {
//            taxiList.add(new Taxi(taxiNames[i], taxiAddresses[i]));
//        }
//
//        setListAdapter(new TaxiAdapter(this, R.layout.taxi_list_item, taxiList));      
//    }
//}
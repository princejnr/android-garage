package android.io.github.nitya.sunshine;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // Commit 1.28 The root view has been created. Now provide some fake data to fill it
            String[] forecastArray = {
                "Today - Rainy - 66/44",
                "Tomorrow - Sunny - 66/44",
                "Thursday - Sunny - 66/44",
                "Friday - Rainy - 66/44",
                "Saturday - Foggy - 66/44",
                "Sunday - Cloudy - 66/44",
                "Monday - Rainy - 66/44"
            };
            // Commit 1.28 And return it as an array list
            List<String> thisWeeksForecast =
                    new ArrayList<String>( Arrays.asList(forecastArray) );

            // Commit 1.29 Initialize ArrayAdapter
            ArrayAdapter<String> forecastAdapter = new ArrayAdapter<String>(
                    getActivity(),                  // provide context
                    R.layout.list_item_forecast,    // identify layout = container
                    R.id.list_item_forecast_textview,// identify list item view = item
                    thisWeeksForecast               // identify data to fill in
            );

            // Commit 1.30: Bind ArrayAdapter to ListView
            // Note how findViewById returns a generic View object that must then be
            //  cast manually to the targeted View subclass of interest.
            ListView forecastListView = (ListView) rootView.findViewById(R.id.listview_forecast);
            forecastListView.setAdapter(forecastAdapter);

            return rootView;
        }
    }
}

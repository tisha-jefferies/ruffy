package org.monkey.d.ruffy.ruffy;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Start extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        getSupportFragmentManager().beginTransaction().add(R.id.container,new StartFragment()).commit();

        SharedPreferences prefs = getSharedPreferences("pumpdata", MODE_PRIVATE);
        boolean paired = prefs.getBoolean("paired", false);
        if (!paired) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new SetupFragment()).addToBackStack("Start").commit();
        }
        else
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new MainFragment()).addToBackStack("Start").commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

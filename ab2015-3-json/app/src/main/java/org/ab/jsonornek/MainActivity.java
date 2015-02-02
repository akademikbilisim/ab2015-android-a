package org.ab.jsonornek;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String ornekString =
                "[{ \"name\": \"Pikachu\", \"level\": 1 }," +
                " { \"name\": \"Raichu\",  \"level\": 2 }," +
                " { \"name\": \"Pichu\",   \"level\": 3 }]";

        try {

            JSONArray pokemons = new JSONArray(ornekString);
            for (int i=0; i<pokemons.length(); i++) {
                JSONObject pokemon = pokemons.getJSONObject(i);
                String name = pokemon.getString("name");
                int level = pokemon.getInt("level");
                Log.i("pokemonListesi", "name: " + name);
                Log.i("pokemonListesi", "level: " + String.valueOf(level));
                Log.i("pokemonListesi", "-------------------------");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

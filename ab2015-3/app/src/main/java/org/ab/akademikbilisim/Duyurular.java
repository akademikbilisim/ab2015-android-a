package org.ab.akademikbilisim;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Duyurular extends ActionBarActivity {

    ListView liste;
    private final String data =
            "[{ \"name\": \"Pikachu\",    \"level\": 1 }," +
            " { \"name\": \"Raichu\",     \"level\": 2 }," +
            " { \"name\": \"Pichu\",      \"level\": 3 }," +
            " { \"name\": \"Bulbasaur\",  \"level\": 4 }," +
            " { \"name\": \"Charmander\", \"level\": 5 }," +
            " { \"name\": \"Charmeleon\", \"level\": 6 }," +
            " { \"name\": \"Charizard\",  \"level\": 7 }," +
            " { \"name\": \"Onix\",       \"level\": 8s }]";
    private ArrayList<String> ayiklanmisVeri;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duyurular);

        liste = (ListView) findViewById(R.id.liste);
        veriyiAyikla();
        adapter = new ArrayAdapter<String>(
                Duyurular.this,
                android.R.layout.simple_list_item_1,
                ayiklanmisVeri
        );
        liste.setAdapter(adapter);
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        Duyurular.this,
                        ayiklanmisVeri.get(position),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private void veriyiAyikla() {
        ayiklanmisVeri = new ArrayList<String>();
        try {

            JSONArray array = new JSONArray(data);
            for (int i=0; i<array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                String name = object.getString("name");
                ayiklanmisVeri.add(name);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_duyurular, menu);
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

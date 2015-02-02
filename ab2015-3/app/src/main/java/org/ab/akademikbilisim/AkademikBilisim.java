package org.ab.akademikbilisim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AkademikBilisim extends ActionBarActivity {

    private static final String LOG_TAG = "AkademikBilisimActivity";

    private EditText yaziAlani;
    private Button btnGoster;
    private String yazi;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akademik_bilisim);
        Log.i(LOG_TAG, "onCreate tetiklendi");

        yaziAlani = (EditText) findViewById(R.id.yazi_alani);
        btnGoster = (Button) findViewById(R.id.btn_goster);
        intent = new Intent(AkademikBilisim.this, Detay.class);

        btnGoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yazi = yaziAlani.getText().toString();
                Toast
                   .makeText(AkademikBilisim.this, yazi, Toast.LENGTH_SHORT)
                   .show();

                intent.putExtra("gonderilen", yazi);
                AkademikBilisim.this.startActivity(intent);

            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
        // Buraya yazdığım kodlar, bu activity onREsume stateine
        // geldiği zaman çalışacak.
        Log.i(LOG_TAG, "Devam.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Burada da, bu activity objem arkaplana geçtiği zaman
        // tetiklenecek.
        Log.i(LOG_TAG, "Duruyorum.");
    }

    @Override
    protected void onDestroy() {
        Log.i(LOG_TAG, "Ben öldüm.");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_akademik_bilisim, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.duyuru){
            // duyuru butonuna tıklandıysa, burayı çalıştır
            Intent duyuruIntent = new Intent(AkademikBilisim.this, Duyurular.class);
            AkademikBilisim.this.startActivity(duyuruIntent);
        }


        return super.onOptionsItemSelected(item);
    }
}

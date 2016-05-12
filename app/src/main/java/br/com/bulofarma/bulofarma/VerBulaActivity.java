package br.com.bulofarma.bulofarma;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by Victor Hugo on 11/05/2016.
 */
public class VerBulaActivity extends Activity {
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_bula_activity);

        lista = (ListView) findViewById(R.id.lista_bula_user);

        registerForContextMenu(lista);
    }
}

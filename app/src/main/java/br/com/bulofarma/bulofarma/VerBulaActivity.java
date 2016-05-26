package br.com.bulofarma.bulofarma;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.bulofarma.bulofarma.apresentacao.BulaAdapter;
import br.com.bulofarma.bulofarma.dados.RepositorioBula;
import br.com.bulofarma.bulofarma.modelo.Bula;

/**
 * Created by Victor Hugo on 11/05/2016.
 */
public class VerBulaActivity extends Activity {
    private ListView lista;
    private List<Bula> bulaList;
    private RepositorioBula repositorioBula;
    private Bula bula;
    private BulaAdapter adapter;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_bula_activity);
        imageButton = (ImageButton) findViewById(R.id.favorito);
        repositorioBula = new RepositorioBula(this);
        bulaList = new ArrayList<>();
        lista = (ListView) findViewById(R.id.lista_bula_user);


        registerForContextMenu(lista);
    }
    @Override
    protected void onResume() {
        super.onResume();
        carregarBulas();
    }

    public void carregarBulas(){
        bulaList = repositorioBula.listar();
       adapter = new BulaAdapter(this, bulaList);
        lista.setAdapter(adapter);
    }

}

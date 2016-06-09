package br.com.bulofarma.bulofarma;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import br.com.bulofarma.bulofarma.apresentacao.BulaAdapter;
import br.com.bulofarma.bulofarma.dados.RepositorioBula;
import br.com.bulofarma.bulofarma.modelo.Bula;

/**
 * Created by Katrina on 26/05/2016.
 */
public class BulaFavoritaActivity extends Activity {
    private ListView lista;
    private List<Bula> bulaList;
    private RepositorioBula repositorioBula;
    private Bula bula;
    private BulaAdapter adapter;
    private EditText edtProcurar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_bula_activity);
        repositorioBula = new RepositorioBula(this);
        lista = (ListView) findViewById(R.id.lista_bula_user);
        edtProcurar = (EditText) findViewById(R.id.search_leaflet);
        edtProcurar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                BulaFavoritaActivity.this.adapter.getFilter().filter(s);

                adapter.setBulaList(bulaList);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        registerForContextMenu(lista);

    }
    @Override
    protected void onResume() {
        super.onResume();
        carregarBulas();
    }

    public void carregarBulas(){
        bulaList = repositorioBula.listarFavorito();
        adapter = new BulaAdapter(this, bulaList);
        lista.setAdapter(adapter);
    }
}

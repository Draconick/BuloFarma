package br.com.bulofarma.bulofarma;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.bulofarma.bulofarma.apresentacao.AlarmeAdapter;
import br.com.bulofarma.bulofarma.dados.RepositorioAlarme;
import br.com.bulofarma.bulofarma.dados.RepositorioBula;
import br.com.bulofarma.bulofarma.modelo.Alarme;
import br.com.bulofarma.bulofarma.modelo.Bula;

/**
 * Created by Katrina on 28/05/2016.
 */
public class AlarmeActivity extends Activity {
    private Alarme alarme;
    private List<Alarme> alarmeList;
    private RepositorioAlarme repositorioAlarme;
    private AlarmeAdapter adapter;
    private ListView listAlarme;
    private PendingIntent alarmIntent;
    private AlarmManager alarmMgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_alarme);
        alarmeList = new ArrayList<>();
        repositorioAlarme = new RepositorioAlarme(this);
        listAlarme = (ListView) findViewById(R.id.lista_alarme);
        carregarBulas();


    }

    public void carregarBulas(){
        alarmeList = repositorioAlarme.listar();
        adapter = new AlarmeAdapter(this,alarmeList);
        listAlarme.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarBulas();
    }

    public void criarAlarme(View view){
        Intent it = new Intent(this, CriarAlarmeActivity.class);
        startActivity(it);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        carregarBulas();
        super.onActivityResult(requestCode, resultCode, data);
    }
}

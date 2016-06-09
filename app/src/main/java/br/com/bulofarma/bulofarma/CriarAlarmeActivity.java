package br.com.bulofarma.bulofarma;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.bulofarma.bulofarma.dados.RepositorioAlarme;
import br.com.bulofarma.bulofarma.dados.RepositorioBula;
import br.com.bulofarma.bulofarma.modelo.Alarme;
import br.com.bulofarma.bulofarma.modelo.Bula;

/**
 * Created by Katrina on 29/05/2016.
 */
public class CriarAlarmeActivity extends Activity {
    private int hora,minuto;
    private Spinner spinnerMedicamentos;
    private Button buttonAlarme;
    private RepositorioBula repositorioBula;
    private List<Bula> bulaList;
    private List<String> medicamentosTitulos;
    private RepositorioAlarme repositorioAlarme;
    private List<Alarme> alarmeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_alarme);
        spinnerMedicamentos = (Spinner) findViewById(R.id.spinner_medicamento);
        buttonAlarme = (Button) findViewById(R.id.button_alarme);
        repositorioAlarme = new RepositorioAlarme(this);
        repositorioBula = new RepositorioBula(this);
        medicamentosTitulos = new ArrayList<>();
        carregarMedicamentos();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,medicamentosTitulos);
        spinnerMedicamentos.setAdapter(adapter);
        Calendar calendar = Calendar.getInstance();
        hora = calendar.get(Calendar.HOUR_OF_DAY);
        minuto = calendar.get(Calendar.MINUTE);
        if(minuto<=9){
            buttonAlarme.setText(hora+":0"+minuto+"h");
        } else
            buttonAlarme.setText(hora+":"+minuto+"h");
    }

    public void selecionarHorario(View view){
        showDialog(view.getId());
    }
    public void carregarMedicamentos(){
        bulaList = repositorioBula.listar();
        for(Bula b : bulaList){
            medicamentosTitulos.add(b.getTitulo());
        }
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        if(R.id.button_alarme == id){
            return new TimePickerDialog(this,listener,hora,minuto,true);
        }
        return null;
    }

    private TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hora = hourOfDay;
            minuto = minute;
            if(minuto<=9){
                buttonAlarme.setText(hora+":0"+minuto+"h");
            } else
                buttonAlarme.setText(hora+":"+minuto+"h");
        }
    };

    public void cadastrarAlarme(View view) {
        String medicamentos =  spinnerMedicamentos.getSelectedItem().toString();
        Alarme alarme = new Alarme(medicamentos,hora,minuto);
        repositorioAlarme.inserir(alarme);
            Intent it = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE,alarme.getMedicamento())
                    .putExtra(AlarmClock.EXTRA_HOUR,alarme.getHora())
                    .putExtra(AlarmClock.EXTRA_MINUTES, alarme.getMinuto());
            if (it.resolveActivity(getPackageManager()) != null) {
                startActivity(it);
            }
        finish();
    }
}

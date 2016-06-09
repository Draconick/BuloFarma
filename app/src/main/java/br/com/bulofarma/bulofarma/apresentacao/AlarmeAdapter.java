package br.com.bulofarma.bulofarma.apresentacao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import br.com.bulofarma.bulofarma.R;
import br.com.bulofarma.bulofarma.dados.RepositorioAlarme;
import br.com.bulofarma.bulofarma.dados.RepositorioBula;
import br.com.bulofarma.bulofarma.modelo.Alarme;
import br.com.bulofarma.bulofarma.modelo.Bula;

/**
 * Created by Katrina on 29/05/2016.
 */
public class AlarmeAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<Alarme> alarmeList;
    private RepositorioAlarme repositorioAlarme;

    public AlarmeAdapter(Context context, List<Alarme> alarmeList){
        this.context = context;
        this.alarmeList = alarmeList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.repositorioAlarme = new RepositorioAlarme(context);
    }

    @Override
    public int getCount() {
        return alarmeList.size();
    }

    @Override
    public Object getItem(int position) {
        return alarmeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.alarme_list,null);
        final Alarme alarme = alarmeList.get(position);
        TextView textTitulo = (TextView) view.findViewById(R.id.titulo_bula_alarme);
        TextView textHorario = (TextView) view.findViewById(R.id.horario_bula_alarme);
        final Switch switchEstado = (Switch) view.findViewById(R.id.switch_estado);
        textTitulo.setText(alarme.getMedicamento());
        if(alarme.getMinuto() <= 9){
            textHorario.setText(alarme.getHora()+":0"+alarme.getMinuto()+"h");
        } else
        textHorario.setText(alarme.getHora()+":"+alarme.getMinuto()+"h");
        if(alarme.getEstado() == 0){
            switchEstado.setChecked(false);
        } else{
            switchEstado.setChecked(true);
        }

        switchEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(alarme.getEstado() == 0){
                    alarme.setEstado(1);
                    repositorioAlarme.mudarEstado(alarme);
                    switchEstado.setChecked(true);
                } else {
                    alarme.setEstado(0);
                    repositorioAlarme.mudarEstado(alarme);
                    switchEstado.setChecked(false);
                }
            }
        });
        return view;
    }
}

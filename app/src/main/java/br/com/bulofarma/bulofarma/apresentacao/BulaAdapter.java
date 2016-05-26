package br.com.bulofarma.bulofarma.apresentacao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import br.com.bulofarma.bulofarma.R;
import br.com.bulofarma.bulofarma.dados.RepositorioBula;
import br.com.bulofarma.bulofarma.modelo.Bula;

/**
 * Created by Katrina on 25/05/2016.
 */
public class BulaAdapter extends BaseAdapter {
    private Context context;
    private List<Bula> bulaList;
    private LayoutInflater inflater;
    private RepositorioBula repositorioBula;

    public BulaAdapter(Context context,List<Bula> bulaList){
        this.context = context;
        this.bulaList = bulaList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.repositorioBula = new RepositorioBula(context);
    }

    @Override
    public int getCount() {
        return bulaList.size();
    }

    @Override
    public Object getItem(int position) {
        return bulaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.bula_list,null);
        final Bula bula = bulaList.get(position);
        TextView textTitulo = (TextView)  view.findViewById(R.id.titulo_bula);
        textTitulo.setText(bula.getTitulo());
        final ImageButton imageFavorito = (ImageButton) view.findViewById(R.id.favorito);
        if(bula.getFavorito() == 0){
            imageFavorito.setImageResource(R.drawable.star_off);
        } else{
            imageFavorito.setImageResource(R.drawable.star_on);
        }
        imageFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bula.getFavorito() == 0){
                    bula.setFavorito(1);
                    repositorioBula.favoritar(bula);
                    imageFavorito.setImageResource(R.drawable.star_on);
                } else{
                    bula.setFavorito(0);
                    repositorioBula.favoritar(bula);
                    imageFavorito.setImageResource(R.drawable.star_off);
                }
            }
        });
        return view;
    }
}

package br.com.bulofarma.bulofarma.apresentacao;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.bulofarma.bulofarma.BulaActivity;
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
        notifyDataSetChanged();
    }

    public List<Bula> getBulaList() {
        return bulaList;
    }

    public void setBulaList(List<Bula> bulaList) {
        this.bulaList = bulaList;
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
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.bula_list,null);
        final Bula bula = bulaList.get(position);
        final TextView textTitulo = (TextView)  view.findViewById(R.id.titulo_bula);
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
        textTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context,BulaActivity.class);
                it.putExtra("bula", textTitulo.getText().toString());
                context.startActivity(it);
            }
        });
        return view;
    }

    public Filter getFilter() {
        Filter filtro = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filtroResultado = new FilterResults();

                if (constraint == null || constraint.length() == 0) {

                    // Se nao tiver nada para filtrar entao retorna a lista completa
                    filtroResultado.values = bulaList;
                    filtroResultado.count = bulaList.size();
                    return filtroResultado;
                } else{

                    List<Bula> bulaLista = new ArrayList<Bula>();

                    for (Bula b : bulaList){
                        if(b.getTitulo().toUpperCase().contains(constraint.toString().toUpperCase())){
                           bulaLista.add(b);
                        }
                    } //Fim do for

                    filtroResultado.values = bulaLista;
                    filtroResultado.count = bulaLista.size();
                }

                return filtroResultado;
            } //FIm do performFiltering

            @Override
            protected void publishResults(CharSequence constraint, FilterResults resultado) {

                //Temos que informar a nova lista
                if (resultado.count == 0)

                    //Notifica os ouvintes
                    notifyDataSetInvalidated();

                else {
                    //Preencho a lista(listaPessoas) do adapter com o novo valor
                    bulaList = (List<Bula>) resultado.values;

                    //Notifica ovites apos a lista ter novos valores
                    notifyDataSetChanged();
                }

            } //Fim do publishResults


        };
        return filtro;
    } //Fim do getFilter
}

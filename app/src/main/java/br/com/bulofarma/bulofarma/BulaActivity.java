package br.com.bulofarma.bulofarma;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.bulofarma.bulofarma.dados.RepositorioBula;
import br.com.bulofarma.bulofarma.modelo.Bula;

/**
 * Created by Katrina on 02/06/2016.
 */
public class BulaActivity extends Activity {
    private ListView listaOpcoes;
    public String[] opcoes = {"Composição","Indicações","ContraIndicações","Modo de Usar","Posologia"
    ,"Advertências","Efeito Colateral"};
    String tituloBula;
    Bula bula;
    private RepositorioBula repositorioBula;
    private TextView textTitulo;
    private List<Bula> bulaList;
    private List<String> stringOpcoes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bula_activity);
        tituloBula = (String) getIntent().getSerializableExtra("bula");
        bula = carregarBula();
        listaOpcoes = (ListView) findViewById(R.id.opcoes_bula);
        stringOpcoes = new ArrayList<>(Arrays.asList(opcoes));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, stringOpcoes){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){

                View view = super.getView(position, convertView, parent);

                final TextView textview = (TextView) view.findViewById(android.R.id.text1);

                textview.setTextSize(40);

                textview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bula = carregarBula();
                        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        final View view1 = inflater.inflate(R.layout.descricao_bula,null);
                        final TextView opcaoDescricao = (TextView) view1.findViewById(R.id.descricao_bula_text);
                        opcaoDescricao.setMovementMethod(new ScrollingMovementMethod());
                        switch (textview.getText().toString()){
                            case "Composição":
                                opcaoDescricao.setText(bula.getComposicao());
                                break;
                            case "Indicações":
                                opcaoDescricao.setText(bula.getIndicacoes());
                                break;
                            case "ContraIndicações":
                                opcaoDescricao.setText(bula.getContraindicacoes());
                                break;
                            case "Modo de Usar":
                                opcaoDescricao.setText(bula.getModoUsar());
                                break;
                            case "Posologia":
                                opcaoDescricao.setText(bula.getPosologia());
                                break;
                            case "Advertências":
                                opcaoDescricao.setText(bula.getAdvertencias());
                                break;
                            case "Efeito Colateral":
                                opcaoDescricao.setText(bula.getEfeitoColateral());
                                break;
                            default:
                                break;
                        }
                        final AlertDialog.Builder builder = new AlertDialog.Builder(BulaActivity.this);
                        builder.setTitle(textview.getText().toString());
                        builder.setView(view1);
                        builder.setPositiveButton("Voltar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.show();

                    }
                });

                return view;
            }
        };
        listaOpcoes.setAdapter(adapter);
        textTitulo = (TextView) findViewById(R.id.text_titulo);
        textTitulo.setText(bula.getTitulo());
        }

    public Bula carregarBula() {
        repositorioBula = new RepositorioBula(this);
        bulaList = repositorioBula.buscarBula(tituloBula);
        bula = bulaList.get(0);
        return bula;
    }

    public void voltar(View v){
        finish();
    }
}

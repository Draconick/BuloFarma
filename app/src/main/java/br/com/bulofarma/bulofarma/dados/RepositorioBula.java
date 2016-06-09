package br.com.bulofarma.bulofarma.dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.bulofarma.bulofarma.modelo.Bula;

/**
 * Created by Katrina on 25/05/2016.
 */
public class RepositorioBula {
    private BulaOpenHelper bulaOpenHelper;

    public RepositorioBula(Context context){
        bulaOpenHelper = new BulaOpenHelper(context);
    }

    public void deletar(Bula bula){
        SQLiteDatabase db = bulaOpenHelper.getWritableDatabase();
        db.delete(bulaOpenHelper.TABELA_BULA,
                "titulo = '"+ bula.getTitulo() + "'", null);
        db.close();
    }

    public List<Bula> listar(){
        SQLiteDatabase db = bulaOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(bulaOpenHelper.TABELA_BULA,
                new String[]{"titulo", "composicao","indicacoes","contraindicacoes","modousar",
                        "posologia","advertencias","efeitocolateral","favorito"},null,null,null,null,
                null);
        List<Bula> bulaList = new ArrayList<>();
        while (cursor.moveToNext()){
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            String composicao = cursor.getString(cursor.getColumnIndex("composicao"));
            String indicacoes = cursor.getString(cursor.getColumnIndex("indicacoes"));
            String contraindicacoes = cursor.getString(cursor.getColumnIndex("contraindicacoes"));
            String modoUsar = cursor.getString(cursor.getColumnIndex("modousar"));
            String posologia = cursor.getString(cursor.getColumnIndex("posologia"));
            String advertencias = cursor.getString(cursor.getColumnIndex("advertencias"));
            String efeitocolateral = cursor.getString(cursor.getColumnIndex("efeitocolateral"));
            String strfavorito = cursor.getString(cursor.getColumnIndex("favorito"));
            int favorito = Integer.parseInt(strfavorito);

            Bula bula = new Bula(titulo,composicao,indicacoes,contraindicacoes,modoUsar,posologia,advertencias,efeitocolateral,favorito);
            bulaList.add(bula);
        }
        db.close();
        return bulaList;
    }
    public List<Bula> listarTeste(String pesquisa){
        SQLiteDatabase db = bulaOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(bulaOpenHelper.TABELA_BULA,
                new String[]{"titulo", "composicao","indicacoes","contraindicacoes","modousar",
                        "posologia","advertencias","efeitocolateral","favorito"},"titulo like '%" + pesquisa + "%'",null,null,null,
                null);
        List<Bula> bulaList = new ArrayList<>();
        while (cursor.moveToNext()){
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            String composicao = cursor.getString(cursor.getColumnIndex("composicao"));
            String indicacoes = cursor.getString(cursor.getColumnIndex("indicacoes"));
            String contraindicacoes = cursor.getString(cursor.getColumnIndex("contraindicacoes"));
            String modoUsar = cursor.getString(cursor.getColumnIndex("modousar"));
            String posologia = cursor.getString(cursor.getColumnIndex("posologia"));
            String advertencias = cursor.getString(cursor.getColumnIndex("advertencias"));
            String efeitocolateral = cursor.getString(cursor.getColumnIndex("efeitocolateral"));
            String strfavorito = cursor.getString(cursor.getColumnIndex("favorito"));
            int favorito = Integer.parseInt(strfavorito);

            Bula bula = new Bula(titulo,composicao,indicacoes,contraindicacoes,modoUsar,posologia,advertencias,efeitocolateral,favorito);
            bulaList.add(bula);
        }
        db.close();
        return bulaList;
    }
    public void favoritar(Bula bula){
        SQLiteDatabase db = this.bulaOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(bula.getFavorito() == 0){
            values.put("favorito", 0);
        } else {
            values.put("favorito", 1);
        }
        db.update(bulaOpenHelper.TABELA_BULA,values,"titulo = '" + bula.getTitulo()+"'", null);
        db.close();
    }

    public List<Bula> listarFavorito(){
        SQLiteDatabase db = bulaOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(bulaOpenHelper.TABELA_BULA,
                new String[]{"titulo", "composicao","indicacoes","contraindicacoes","modousar",
                        "posologia","advertencias","efeitocolateral","favorito"},"favorito = 1",null,null,null,
                null);
        List<Bula> bulaList = new ArrayList<>();
        while (cursor.moveToNext()){
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            String composicao = cursor.getString(cursor.getColumnIndex("composicao"));
            String indicacoes = cursor.getString(cursor.getColumnIndex("indicacoes"));
            String contraindicacoes = cursor.getString(cursor.getColumnIndex("contraindicacoes"));
            String modoUsar = cursor.getString(cursor.getColumnIndex("modousar"));
            String posologia = cursor.getString(cursor.getColumnIndex("posologia"));
            String advertencias = cursor.getString(cursor.getColumnIndex("advertencias"));
            String efeitocolateral = cursor.getString(cursor.getColumnIndex("efeitocolateral"));
            String strfavorito = cursor.getString(cursor.getColumnIndex("favorito"));
            int favorito = Integer.parseInt(strfavorito);

            Bula bula = new Bula(titulo,composicao,indicacoes,contraindicacoes,modoUsar,posologia,advertencias,efeitocolateral,favorito);
            bulaList.add(bula);
        }
        db.close();
        return bulaList;
    }

    public List<Bula> buscarBula(String bulaEscolhida){
        SQLiteDatabase db = bulaOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(bulaOpenHelper.TABELA_BULA,
                new String[]{"titulo", "composicao","indicacoes","contraindicacoes","modousar",
                        "posologia","advertencias","efeitocolateral","favorito"},
                "titulo ='"+bulaEscolhida+"'",null,null,null,null);
        List<Bula> bulaList = new ArrayList<>();
        while (cursor.moveToNext()) {
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            String composicao = cursor.getString(cursor.getColumnIndex("composicao"));
            String indicacoes = cursor.getString(cursor.getColumnIndex("indicacoes"));
            String contraindicacoes = cursor.getString(cursor.getColumnIndex("contraindicacoes"));
            String modoUsar = cursor.getString(cursor.getColumnIndex("modousar"));
            String posologia = cursor.getString(cursor.getColumnIndex("posologia"));
            String advertencias = cursor.getString(cursor.getColumnIndex("advertencias"));
            String efeitocolateral = cursor.getString(cursor.getColumnIndex("efeitocolateral"));
            String strfavorito = cursor.getString(cursor.getColumnIndex("favorito"));
            int favorito = Integer.parseInt(strfavorito);

            Bula bula = new Bula(titulo, composicao, indicacoes, contraindicacoes,
                    modoUsar, posologia, advertencias, efeitocolateral, favorito);
            bulaList.add(bula);
        }
        db.close();

        return bulaList;
    }
}

package br.com.bulofarma.bulofarma.dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.bulofarma.bulofarma.modelo.Alarme;

/**
 * Created by Katrina on 29/05/2016.
 */
public class RepositorioAlarme {
    private AlarmeOpenHelper alarmeOpenHelper;

    public RepositorioAlarme(Context context){
        alarmeOpenHelper = new AlarmeOpenHelper(context);
    }
    public void inserir(Alarme alarme){
        SQLiteDatabase db = alarmeOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("medicamento", alarme.getMedicamento());
        values.put("hora", alarme.getHora());
        values.put("minuto", alarme.getMinuto());
        values.put("estado",alarme.getEstado());
        db.insert(alarmeOpenHelper.TABELA_ALARME, null,values);
        db.close();

    }
    public List<Alarme> listar(){
        SQLiteDatabase db = alarmeOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(alarmeOpenHelper.TABELA_ALARME,
                new String[]{"id","medicamento","hora","minuto","estado"},null,null,null,null,null);
        List<Alarme> alarmeList = new ArrayList<>();
        while (cursor.moveToNext()){
            int idBula = cursor.getInt(cursor.getColumnIndex("id"));
            String medicamento = cursor.getString(cursor.getColumnIndex("medicamento"));
            int hora = cursor.getInt(cursor.getColumnIndex("hora"));
            int minuto = cursor.getInt(cursor.getColumnIndex("minuto"));
            int estado = cursor.getInt(cursor.getColumnIndex("estado"));
            Alarme alarme = new Alarme(idBula,medicamento,hora,minuto,estado);
            alarmeList.add(alarme);
        }
     return alarmeList;
    }

    public void mudarEstado(Alarme alarme){
        SQLiteDatabase db = alarmeOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(alarme.getEstado() == 0){
            values.put("estado", 0);
        } else {
            values.put("estado", 1);
        }
        db.update(alarmeOpenHelper.TABELA_ALARME,values,"id = '"+ alarme.getIdBula()
                + "'",null);
        db.close();
    }
}

package br.com.bulofarma.bulofarma.dados;

import android.content.Context;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.bulofarma.bulofarma.modelo.Administrador;


import br.com.bulofarma.bulofarma.modelo.Administrador;

/**
 * Created by Katrina on 24/05/2016.
 */
public class RepositorioAdministrador {
    private AdministradorOpenHelper administradorOpenHelper;

    public RepositorioAdministrador(Context context){
        administradorOpenHelper = new AdministradorOpenHelper(context);
    }

    public List<Administrador> listar(){
        SQLiteDatabase db = administradorOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(administradorOpenHelper.TABELA_ADMIN,
                new String[]{"usuario", "senha"}, null, null, null, null, null);
        List<Administrador> listarAdministrador = new ArrayList<Administrador>();
        while(cursor.moveToNext()){
            String user = cursor.getString(cursor.getColumnIndex("usuario"));
            String senha = cursor.getString(cursor.getColumnIndex("senha"));
            Administrador administrador = new Administrador(user,senha);
            listarAdministrador.add(administrador);
        }
        return listarAdministrador;
    }
}

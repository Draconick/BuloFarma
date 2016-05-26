package br.com.bulofarma.bulofarma.dados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Katrina on 24/05/2016.
 */
public class AdministradorOpenHelper extends SQLiteOpenHelper {
    public static final String TABELA_ADMIN = "administrador";
    private static final String DATABASE_NAME = "administrador_database";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_TABELA_ADMIN = "CREATE TABLE " + TABELA_ADMIN + "(" +
            "usuario text not null primary key," +
            "senha text not null)";
    private static final String SQL_INSERT_ADMIN = "INSERT INTO " + TABELA_ADMIN +"(" +
            "usuario,senha) values" +
            "('admin','admin123')";

    public AdministradorOpenHelper(Context contexto){
        super(contexto,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_TABELA_ADMIN);
        db.execSQL(SQL_INSERT_ADMIN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

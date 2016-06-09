package br.com.bulofarma.bulofarma.dados;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Katrina on 29/05/2016.
 */
public class AlarmeOpenHelper extends SQLiteOpenHelper {
    public static final String TABELA_ALARME = "alarme";
    private static final String DATABASE_ALARME = "alarme_database";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_TABELA_ALARME = "CREATE TABLE " + TABELA_ALARME + "(" +
            "id integer not null primary key autoincrement," +
            "medicamento text not null," +
            "hora int not null," +
            "minuto int not null," +
            "estado int not null)";

    public AlarmeOpenHelper(Context context) {
        super(context, DATABASE_ALARME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_TABELA_ALARME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
package com.victorandrade.gerenciadordelivros.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String BD_NAME = "livrosbd";
    public static final int BD_VERSION = 1;

    private static DBHelper instance;


    private String SQl_CREATE = String.format(
      "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
       " %s TEXT NOT NULL, %s TEXT NOT NULL, " +
       "%s TEXT NOT NULL, %s INTEGER NOT NULL)",
            LivroContract.TABLE_NAME,
            LivroContract.Columns._ID,
            LivroContract.Columns.titulo,
            LivroContract.Columns.autor,
            LivroContract.Columns.editora,
            LivroContract.Columns.emprestado
        );
    private String SQL_DROP = "DROP TABLE IF EXISTS "+ LivroContract.TABLE_NAME;


    private DBHelper(Context context){
        super(context, BD_NAME, null, BD_VERSION);
    }

    public static  DBHelper getInstance(Context context){
        if(instance == null){
            instance = new DBHelper(context);
        }
        return  instance;
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(SQL_DROP);
        bd.execSQL(SQl_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd , int oldVersion, int newVersion) {
        onCreate(bd);
    }
}

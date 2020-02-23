package com.example.juegoppt;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BaseDate extends SQLiteOpenHelper {
    private static ArrayList<players> array_jugadores = new ArrayList<>();

    public BaseDate(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table jugadores(Codigo integer (100) primary key, Nombre varchar(45) not null, Puntuacion integer (10000))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("drop table if exists jugadores");
        db.execSQL("create table jugadores(Codigo integer (100) primary key, Nombre varchar(45) not null, Puntuacion  integer (10000))");
    }
    //metodo listar registro de la db
    public ArrayList<players> getAlljugadores()
    {
        //jugador creado para poder ir insertandolos en el arrray list de jugadores
        players jugador = new players();

        //Array list de jugadores

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from jugadores", null );
        res.moveToFirst();

        // Para Añadir cada jugador guardado en mi base de datos en un arrayList
        while(res.isAfterLast() == false){
            jugador.setId(Integer.parseInt(res.getString(0)));
            jugador.setNombre(res.getString(1));
            jugador.setPuntuacion(Integer.parseInt(res.getString(2)));
            array_jugadores.add(jugador);
            res.moveToNext();}

        return array_jugadores;
    }
    public ArrayList<String>  getMejoresPuntuacios(){

        //Array list de jugadores
        ArrayList<String> array_list = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from jugadores ORDER BY Puntuacion DESC", null );
        res.moveToFirst();
        // Para Añadir cada jugador guardado en mi base de datos en un arrayList
        while(res.isAfterLast() == false){
            array_list.add("Codigo: "+res.getInt(0) +"\n "+"\n "+" "+
                    res.getString(1) + "\n "+"\n "+ res.getInt(2));
            res.moveToNext();}

        return array_list;
    }
}

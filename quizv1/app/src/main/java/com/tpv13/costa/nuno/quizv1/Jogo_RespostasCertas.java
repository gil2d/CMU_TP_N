package com.tpv13.costa.nuno.quizv1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;

/**
 * Created by Nuno on 05-12-2016.
 */

public class Jogo_RespostasCertas implements Parcelable {
    private int categoriaId;
    private int pontuacao;
    private MyDbHelper_game dbHelper;


    public Jogo_RespostasCertas(int _categoriaId, int _pontuacao, Context context){
        this.categoriaId=_categoriaId;
        this.pontuacao=_pontuacao;
        dbHelper = new MyDbHelper_game(context);
    }

    protected Jogo_RespostasCertas(Parcel in) {
        categoriaId = in.readInt();
        pontuacao = in.readInt();
    }

    public static final Creator<Jogo_RespostasCertas> CREATOR = new Creator<Jogo_RespostasCertas>() {
        @Override
        public Jogo_RespostasCertas createFromParcel(Parcel in) {
            return new Jogo_RespostasCertas(in);
        }

        @Override
        public Jogo_RespostasCertas[] newArray(int size) {
            return new Jogo_RespostasCertas[size];
        }
    };

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getDescricaoCategoria(){
        String[] columnsSelect={"Descricao"};
        String categoriaDescr="";


        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //Cursor c = db.rawQuery("SELECT * FROM tblPessoas", null);
        Cursor c= db.query(true,"Categorias",columnsSelect,"Id='" + getCategoriaId() + "'",null,null,null,null,null);

        // Check if our result was valid.

        try
        {
            if (c.getCount()>0 ) {
                c.moveToFirst();
                // Loop through all Results
                categoriaDescr=c.getColumnName(0);
            }
            c.close();
            db.close();

        }
        catch(Exception e) {
            Log.e("Error", "Error", e);
            throw e;
        }

        return categoriaDescr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(categoriaId);
        parcel.writeInt(pontuacao);
    }
}

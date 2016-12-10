package com.tpv13.costa.nuno.quizv1;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class NovoJogoOpcoes extends ListActivity implements View.OnClickListener {
    private MyDbHelper_game dbHelper;
    private ArrayList<Nivel> mNivel =new ArrayList<>();
    private ArrayList<Categoria> mCategoria =new ArrayList<>();
    private ListAdapter_niveis mAdapter_niveis;
    private ListAdapter_categorias mAdapter_catgs;
    private ArrayList<Integer> tmp_lstPerguntas;

    private Button bt_jogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{

            setContentView(R.layout.activity_novo_jogo_opcoes);

            //ListView lstNiveis = (ListView) findViewById(R.id.lst_categorias) ;
            ListView lstCatgs = (ListView) findViewById(R.id.lst_categorias);

            bt_jogar = (Button) findViewById(R.id.bt_jogar);
            bt_jogar.setOnClickListener(this);

            dbHelper = new MyDbHelper_game(this);

            iniNiveis();
            iniCategorias();

            mAdapter_niveis = new ListAdapter_niveis(this, mNivel);
            setListAdapter(mAdapter_niveis);

            mAdapter_catgs = new ListAdapter_categorias(this, mCategoria);
            lstCatgs.setAdapter(mAdapter_catgs);


        } catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }

    }

    public void onResume()
    {
        super.onResume();
        mAdapter_niveis.notifyDataSetChanged();
//        mAdapter_catgs.notifyDataSetChanged();

        tmp_lstPerguntas=new ArrayList<>();
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mAdapter_niveis.setSelectedIndex(position);
        mAdapter_niveis.notifyDataSetChanged();
    }



    private void iniNiveis(){

        mNivel.clear();

        String[] columnsNiveisSelect={
                "Id",
                "Nome",
                "Descricao"};



        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //Cursor c = db.rawQuery("SELECT * FROM tblPessoas", null);
        Cursor c= db.query(true,"Niveis",columnsNiveisSelect,null,null,null,null,"Nome",null);

        // Check if our result was valid.

        try
        {
            if (c.getCount()>0 ) {
                c.moveToFirst();
                // Loop through all Results
                do {
                    mNivel.add(new Nivel(c.getInt(0), c.getString(1), c.getString(2)));

                }while(c.moveToNext());
            }
                c.close();
                db.close();


        }
        catch(Exception e) {
            Log.e("Error", "Error", e);
            throw e;
        }
        //////
    }

    private void iniCategorias(){

        mCategoria.clear();

        String[] columnsNiveisSelect={
                "Id",
                "Descricao" };



        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //Cursor c = db.rawQuery("SELECT * FROM tblPessoas", null);
        Cursor c= db.query(true,"Categorias",columnsNiveisSelect,null,null,null,null,"Descricao",null);

        // Check if our result was valid.

        try
        {
            if (c != null) {
                c.moveToFirst();
                // Loop through all Results
                do {
                    mCategoria.add(new Categoria(c.getInt(0), c.getString(1)));

                }while(c.moveToNext());

                c.close();
                db.close();
            }

        }
        catch(Exception e) {
            Log.e("Error", "Error", e);
            throw e;
        }
        //////
    }


    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.bt_jogar)
        {
            if (mAdapter_niveis.getSelectedIndex()!=-1 &&
                mAdapter_catgs.getCheckedpositionsCount() >0   )  {

//                Toast.makeText(this, "VAMOS JOGAR o nível " + mNivel.get(mAdapter_niveis.getSelectedIndex()).getNome() , Toast.LENGTH_LONG).show();

                tmp_lstPerguntas= lstPerguntas(mNivel.get(mAdapter_niveis.getSelectedIndex()).getId(),
                        mAdapter_catgs.getCheckedpositions());

                if (tmp_lstPerguntas.size()>0) {
                    Intent i = new Intent(this, JogarActivity.class);
//                i.putExtra("Nivel",  mNivel.get(mAdapter_niveis.getSelectedIndex()).getId());
//                i.putExtra("Categorias",  mAdapter_catgs.getCheckedpositions());
                    i.putExtra("Perguntas", tmp_lstPerguntas);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(this, "Não existem perguntas para a selecção escolhida.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private ArrayList<Integer> lstPerguntas(int _nivel, ArrayList<Integer> _categorias){
        ArrayList<Integer> lstPerg = new ArrayList<>();

        String[] columnsPerguntasSelect={"Id"};
        String WHERE =  "Niveis_Id='" + _nivel + "' AND (";

                for (int i=0;i< _categorias.size();i++){
                    WHERE= WHERE + "Categorias_Id= '" + _categorias.get(i) + "' OR ";
                }

        WHERE= WHERE.substring(0,WHERE.length()-3) + ")";

//        Toast.makeText(this, WHERE , Toast.LENGTH_LONG).show();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //Cursor c = db.rawQuery("SELECT * FROM tblPessoas", null);
        Cursor c= db.query(true,"Perguntas",columnsPerguntasSelect,WHERE,null,null,null,null,null);

        try
        {
            if (c.getCount()>0 ) {
                c.moveToFirst();
                // Loop through all Results
                do {
                    lstPerg.add(c.getInt(0));
                }while(c.moveToNext());
            }
            c.close();
            db.close();

        }
        catch(Exception e) {
            Log.e("Error", "Error", e);
            throw e;
        }

        return  lstPerg;
    }



}

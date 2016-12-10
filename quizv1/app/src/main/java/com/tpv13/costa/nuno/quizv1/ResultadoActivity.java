package com.tpv13.costa.nuno.quizv1;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
//import android.support.annotation.RequiresApi;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

public class ResultadoActivity extends Activity {

    private ArrayList<Jogo_RespostasCertas> rspCertas = new ArrayList<>();
    private ArrayList<Integer> rspCatgs = new ArrayList<>();
    private int killProcess;


   // @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        this.rspCertas = (ArrayList<Jogo_RespostasCertas>) getIntent().getSerializableExtra("ResultadosLst");
        this.killProcess = getIntent().getIntExtra("KillProcess", 0);
        this.rspCatgs=getIntent().getIntegerArrayListExtra("RspCertasCategorias");
        //getIntent().getStringExtra("Frase")
        //getIntent().getIntExtra("Pontuacao",0)

        TextView tmp = (TextView) findViewById(R.id.a);
        TextView tmp2 = (TextView) findViewById(R.id.fraseResultado);

        tmp2.setText("" + getIntent().getStringExtra("Frase") + "\n\nPontuação Total: " + getIntent().getIntExtra("Pontuacao",0));


        HashSet noDupSet = new HashSet();
        noDupSet.add(rspCatgs);

//        tmp.setText("" + noDupSet.size());
        tmp.setText("");

    }



}

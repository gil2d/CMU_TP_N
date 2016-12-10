package com.tpv13.costa.nuno.quizv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_novoJogo, bt_estatisticas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_novoJogo = (Button) findViewById(R.id.bt_novoJogo);
        bt_novoJogo.setOnClickListener(this);

        bt_estatisticas = (Button) findViewById(R.id.bt_estatisticas);
        bt_estatisticas.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bt_novoJogo: //error
                startActivity(new Intent(this, NovoJogoOpcoes.class));
                break;
            case R.id.bt_estatisticas: //error
                //launch activity
                break;
            default:
                break;
        }
    }
}

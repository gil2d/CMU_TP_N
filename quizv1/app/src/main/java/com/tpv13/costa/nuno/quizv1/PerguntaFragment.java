package com.tpv13.costa.nuno.quizv1;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nuno on 04-12-2016.
 */

public class PerguntaFragment extends Fragment implements View.OnClickListener {


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
           // mListener = (OnPersonSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnPersonSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mContentView = inflater.inflate(R.layout.fragment_pergunta, container, false);

        Button btnA = (Button) mContentView.findViewById(R.id.bt_respostaA);
        btnA.setOnClickListener(this);

        Button btnB = (Button) mContentView.findViewById(R.id.bt_respostaB);
        btnB.setOnClickListener(this);

        Button btnC = (Button) mContentView.findViewById(R.id.bt_respostaC);
        btnC.setOnClickListener(this);

        Button btnD = (Button) mContentView.findViewById(R.id.bt_respostaD);
        btnD.setOnClickListener(this);

        return mContentView;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_respostaA: //error
                Toast.makeText(this.getContext(), "RespostaA", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_respostaB: //error
                Toast.makeText(this.getContext(), "RespostaB", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_respostaC: //error
                Toast.makeText(this.getContext(), "RespostaC", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_respostaD: //error
                Toast.makeText(this.getContext(), "RespostaD", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}

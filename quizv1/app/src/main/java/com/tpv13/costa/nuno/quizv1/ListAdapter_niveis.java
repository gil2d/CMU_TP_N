package com.tpv13.costa.nuno.quizv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.RadioButton;

import java.util.ArrayList;

/**
 * Created by Nuno on 03-12-2016.
 */

public class ListAdapter_niveis extends ArrayAdapter<Nivel> implements Checkable
{
    private Context context;
    private ArrayList<Nivel> niveisList;
    private int selectedIndex = -1;

    public ListAdapter_niveis(Context context, ArrayList<Nivel> list) {
        super(context,R.layout.row_niveis,list);

        this.niveisList = list;
        this.context = context;

    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;

        if(v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_niveis, null);
        }

        RadioButton rNivel = (RadioButton) v.findViewById(R.id.rb_nivel);

        if(getSelectedIndex() == position){
            rNivel.setChecked(true);
        }
        else{
            rNivel.setChecked(false);
        }

//
        rNivel.setText(niveisList.get(position).getNome());


        return v;

    }

    @Override
    public void setChecked(boolean b) {

    }

    @Override
    public boolean isChecked() {
        return false;
    }

    @Override
    public void toggle() {

    }

    public void setSelectedIndex(int index){
        selectedIndex = index;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }
}

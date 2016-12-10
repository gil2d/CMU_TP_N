package com.tpv13.costa.nuno.quizv1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;

/**
 * Created by Nuno on 03-12-2016.
 */

public class ListAdapter_categorias extends ArrayAdapter<Categoria> {//implements View.OnClickListener {
    private Context context;
    private ArrayList<Categoria> categoriasList;
    private ArrayList<Integer> checkedpositions;


    public ListAdapter_categorias(Context context, ArrayList<Categoria> list) {
        super(context,R.layout.row_categorias,list);

        this.categoriasList = list;
        this.context = context;

        this.setCheckedpositions(new  ArrayList<Integer>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;

        if(v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_categorias, null);
        }



        final CheckBox cCategoria = (CheckBox) v.findViewById(R.id.cb_categoria);
        cCategoria.setText(categoriasList.get(position).getDescricao());
        //cCategoria.setOnClickListener(this);
        cCategoria.setTag(categoriasList.get(position).getId());
//        cCategoria.setChecked(true);
//        getCheckedpositions().add(categoriasList.get(position).getId());

        cCategoria.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                                       /*get the tag of the checkbox...in this case this will give the (position of view)*/
                int tag=(int)cCategoria.getTag();
                if ( isChecked )
                {
                    // perform logic
//                    count++;
                    Log.d("Checkbox","added "+tag);
                    getCheckedpositions().add(tag);
                }
                else
                {
//                    count--;
                    getCheckedpositions().remove(getCheckedpositions().indexOf(tag));
                    Log.d("Checkbox","removed "+tag);
                }



//            } catch (IOException e) {
//            // TODO Auto-generated catch block
//            Log.d("error", "wall");
            }

        });

        return v;

    }

    public ArrayList<Integer> getCheckedpositions() {
        return checkedpositions;
    }

    public void setCheckedpositions(ArrayList<Integer> checkedpositions) {
        this.checkedpositions = checkedpositions;
    }

    public int getCheckedpositionsCount()
    {
        return this.getCheckedpositions().size();
    }


}
//
//class CheckBoxItem{
//
//    boolean isSelected;
//
//
//
//    public void setSelected(boolean val) {
//        this.isSelected = val;
//    }
//
//    boolean isSelected(){
//        return isSelected;
//
//    }
//
//}

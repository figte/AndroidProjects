package com.example.apptareas.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.apptareas.R;
import com.example.apptareas.model.Tarea;

import java.util.List;

public class TareaAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<Tarea> model;

    public TareaAdapter(Context context,int layout,List<Tarea> model){
        this.context=context;
        this.layout=layout;
        this.model=model;
    }



    @Override
    public int getCount() {
        return this.model.size();
    }

    @Override
    public Object getItem(int i) {
        return this.model.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.model.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater l=LayoutInflater.from(this.context);

        View v=view;
        v=l.inflate(R.layout.item_tarea,null);

        TextView id=(TextView) v.findViewById(R.id.txtId);
        TextView titulo=(TextView) v.findViewById(R.id.txtTitulo);
        TextView descripcion=(TextView) v.findViewById(R.id.txtDescripcion);

        Tarea tarea=this.model.get(i);

        id.setText(tarea.getId().toString());
        titulo.setText(tarea.getTitulo());
        descripcion.setText(tarea.getDescripcion());

        return v;
    }

}

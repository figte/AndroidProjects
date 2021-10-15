package com.example.apptareas02.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptareas02.NuevaTareaActivity;
import com.example.apptareas02.R;
import com.example.apptareas02.dao.TareaDao;
import com.example.apptareas02.model.Tarea;

import java.util.List;

public class TareaAdapter extends RecyclerView.Adapter<TareaAdapter.ViewHolder> {

    List<Tarea> tareas;
    Context context;

    TareaDao dao;

    //manipulacion de vista(xml)
    public static class ViewHolder extends RecyclerView.ViewHolder  {

        TextView txtId;
        TextView txtTarea;

        Button btnModificar;
        Button btnEliminar;

        Context context;

        public  ViewHolder(View view,Context context){
            super(view);
             txtId=(TextView) view.findViewById(R.id.txtId);
             txtTarea=(TextView) view.findViewById(R.id.txtNombre);
             btnModificar=(Button) view.findViewById(R.id.btnModificar);
             btnEliminar=(Button) view.findViewById(R.id.btnEliminar);

             this.context=context;

             //enlazando
            //  btnModificar.setOnClickListener(this);
            //  btnEliminar.setOnClickListener(this);
        }


       /* @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnEliminar:
                        Toast.makeText(view.getContext(),"Tarea: "+txtTarea.getText(),Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnModificar:
                    Intent intent = new Intent(view.getContext(), NuevaTareaActivity.class);
                    intent.putExtra("estado",1);
                    view.getContext().startActivity(intent);

                    break;

            }
        }*/
    }

    //constructor del adaptador
    public TareaAdapter(List<Tarea> tareas, Context context,TareaDao dao){
        this.context=context;
        this.tareas=tareas;
        this.dao=dao;
    }


    //configuraciones
    @NonNull
    @Override
    public TareaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarea,parent,false);
        ViewHolder vh=new ViewHolder(v,context);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TareaAdapter.ViewHolder holder, int position) {
        Tarea t=tareas.get(position);
        holder.txtId.setText(""+t.getId());
        holder.txtTarea.setText(t.getNombre());
        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.delete(t);

                tareas=dao.getAll();

                notifyDataSetChanged();

                Toast.makeText(context.getApplicationContext(),"ELiminado",Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NuevaTareaActivity.class);
                intent.putExtra("estado",1);
                intent.putExtra("tarea",t);
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return tareas.size();
    }
}

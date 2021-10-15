package com.example.apptareas02.dao;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.apptareas02.Data.SharedPreferenceConfig;
import com.example.apptareas02.model.Tarea;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class TareaDaoImpSharedPreference implements TareaDao{

    SharedPreferenceConfig config;
    int contador;


    public TareaDaoImpSharedPreference(Context context) {
        config=new SharedPreferenceConfig(context);
       // config.delete();
        contador=config.getPreferences().getInt("contador",0);

    }


    @Override
    public List<Tarea> getAll() {
        List<Tarea> tareas= new ArrayList<Tarea>();

        for (int i = 1; i <=contador; i++) {
            Tarea tarea=new Tarea();
            try{

                Set<String> t=config.getPreferences().getStringSet("tarea"+i,new HashSet<>());

                String[] items= t.toArray(new String[t.size()]);

                tarea.setId(Integer.parseInt(items[1]));
                tarea.setNombre(items[0]);

                tareas.add(tarea);
           }catch (Exception e){

            }


        }

        return tareas;
    }

    @Override
    public Tarea get(int id) {
        return null;
    }

    @Override
    public void save(Tarea entity) {
        //persistecia
        SharedPreferences.Editor editor=config.getPreferences().edit();

        contador++;

        entity.setId(contador);

        Set<String> tarea= new HashSet<>();
        tarea.add(""+entity.getId());
        tarea.add(entity.getNombre());

        editor.putStringSet("tarea"+contador, tarea);
        editor.putInt("contador",contador);

        editor.commit();
    }

    @Override
    public void delete(Tarea entity) {

    }

    @Override
    public void update(Tarea entity) {

    }
}

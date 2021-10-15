package com.example.apptareas02.dao;

import android.content.Context;

import androidx.room.Room;

import com.example.apptareas02.Data.DataBaseRoom;
import com.example.apptareas02.model.Tarea;

import java.util.List;

public class TareaDaoImpRoom implements TareaDao{

    DataBaseRoom db;

    TareaDao dao;

    public TareaDaoImpRoom(Context context){
        db= Room.databaseBuilder(context,DataBaseRoom.class,"db")
                .allowMainThreadQueries().build();
        dao=db.tareaDao();
    }

    @Override
    public List<Tarea> getAll() {
        return dao.getAll();
    }

    @Override
    public Tarea get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(Tarea entity) {
            dao.save(entity);
    }

    @Override
    public void delete(Tarea entity) {
        dao.delete(entity);
    }

    @Override
    public void update(Tarea entity) {
        dao.update(entity);
    }
}

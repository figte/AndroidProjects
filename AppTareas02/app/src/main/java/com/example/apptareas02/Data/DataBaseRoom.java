package com.example.apptareas02.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.apptareas02.dao.TareaDao;
import com.example.apptareas02.model.Tarea;

@Database(entities = {Tarea.class}, version = 1)
public  abstract  class DataBaseRoom extends RoomDatabase {
    public abstract TareaDao tareaDao();
}

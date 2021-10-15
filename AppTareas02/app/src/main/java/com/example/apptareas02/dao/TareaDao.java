package com.example.apptareas02.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.apptareas02.model.Tarea;

import java.util.List;

@Dao
public interface TareaDao{

    @Query("select * from tareas")
    public List<Tarea> getAll();

    @Query("select * from tareas where id = :id")
    public Tarea get(int id);

    @Insert
    public void save(Tarea entity);

    @Delete
    public void delete(Tarea entity);

    @Update
    public void update(Tarea entity);
}



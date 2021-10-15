package com.example.apptareas02.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tareas")
public class Tarea implements Serializable {


    @PrimaryKey(autoGenerate = true)
    int id;

    String nombre;

    public Tarea() {
    }

    public Tarea(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

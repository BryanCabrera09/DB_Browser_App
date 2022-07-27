package com.brytech.appdbbrowser.Modelo;

import android.content.Context;
import android.database.Cursor;

public class Persona {

    private String id;
    private String nombre;
    private String apellido;
    private String correo;

    public void guardarPersona(Context mc) {
        TiendaSQLHelper tiendaSQLHelper = new TiendaSQLHelper(mc);
        String sql;
        sql = "INSERT INTO personas (id,nombre,apellido,correo)";
        sql += "VALUES ('" + getId() + "','" + getNombre() + "','" + getApellido() + "','" + getCorreo() + "')";
        tiendaSQLHelper.getWritableDatabase().execSQL(sql);
    }

    public static Cursor listaPersonas(Context mc) {
        TiendaSQLHelper tiendaSQLHelper = new TiendaSQLHelper(mc);
        String sql = "select _rowid_ as _id,* from personas";
        return
                tiendaSQLHelper.getReadableDatabase().rawQuery(sql, null);
    }

    public void actualizarPersona(Context mc) {
        TiendaSQLHelper tiendaSQLHelper = new TiendaSQLHelper(mc);
        String sql;
        sql = "UPDATE personas ";
        sql += "SET nombre='" + getNombre() + "',apellido='" + getApellido() + "',correo='" + getCorreo() + "' WHERE id='" + getId() + "'";
        tiendaSQLHelper.getWritableDatabase().execSQL(sql);
    }

    public void eliminarPersona(Context mc) {
        TiendaSQLHelper tiendaSQLHelper = new TiendaSQLHelper(mc);
        String sql;
        sql = "DELETE FROM personas ";
        sql += "WHERE id='" + getId() + "'";
        tiendaSQLHelper.getWritableDatabase().execSQL(sql);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

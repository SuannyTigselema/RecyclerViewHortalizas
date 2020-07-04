package android.studio.recyclerviewhortalizas.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class producto {
    public String nombre;
    public String descripcion;
    public String unidad;
    public String precio;
    public String url;

    public producto(JSONObject a) throws JSONException {
        this.nombre = a.getString("nombre").toString();
        this.descripcion = a.getString("descripcion").toString();
        this.unidad = a.getString("unidad").toString();
        this.precio = a.getString("precio").toString();
        this.url = a.getString("imagen").toString();
    }
    //Metodo para parsear los datos
    public static ArrayList<producto> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<producto> producto = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            producto.add(new producto(datos.getJSONObject(i)));
        }
        return producto;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

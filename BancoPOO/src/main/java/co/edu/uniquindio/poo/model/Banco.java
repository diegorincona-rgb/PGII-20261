package co.edu.uniquindio.poo.model;

import co.edu.uniquindio.poo.model.CuentasBancarias.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre;
    private int id;
    private String direccion;
    private int telefono;

    private List<Usuario> listUsuarios;
    private List<Cuenta> listCuentas;

    public  Banco(String nombre, int id, String direccion, int telefono) {
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        listUsuarios = new ArrayList<Usuario>();
        listCuentas = new ArrayList<Cuenta>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public List<Cuenta> getListCuentas() {
        return listCuentas;
    }

    public void setListCuentas(List<Cuenta> listCuentas) {
        this.listCuentas = listCuentas;
    }
}

package co.edu.uniquindio.poo.model;

import co.edu.uniquindio.poo.model.CuentasBancarias.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private int id;
    private int telefono;
    private String direccion;
    private String fechaNacimiento;

    private List<Cuenta> listCuentasUsuario;

    public Usuario(String nombre, int id, int telefono, String direccion, String fechaNacimiento) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;

        this.listCuentasUsuario = new ArrayList<Cuenta>();
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Cuenta> getListCuentasUsuario() {
        return listCuentasUsuario;
    }

    public void setListCuentasUsuario(List<Cuenta> listCuentasUsuario) {
        this.listCuentasUsuario = listCuentasUsuario;
    }
}

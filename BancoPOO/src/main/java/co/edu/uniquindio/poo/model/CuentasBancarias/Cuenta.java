package co.edu.uniquindio.poo.model.CuentasBancarias;

import co.edu.uniquindio.poo.model.Usuario;

public abstract class Cuenta {
    private String numeroCuenta;
    protected Usuario titular;
    protected double saldo;
    private String fechaApertura;
    protected Estado estado;

    public Cuenta(String numeroCuenta, Usuario titular, double saldo, String fechaApertura, Estado estado) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
    }

    public abstract void depositar(double cantidad);

    public abstract void retirar(double cantidad);

    public void bloquear() {
        if (estado == Estado.ACTIVA) {
            estado = Estado.BLOQUEADA;
            System.out.println("La cuenta ha sido bloqueada.");
        }
    }

    public void desbloquear() {
        if (estado == Estado.BLOQUEADA) {
            estado = Estado.ACTIVA;
            System.out.println("La cuenta ha sido desbloqueada.");

        }
    }

    public void cerrar() {
        estado = Estado.CERRADA;
        System.out.println("La cuenta ha sido cerrada.");
    }

    public void mostrarInformacion() {
        System.out.println("Cuenta: " + numeroCuenta +
                " | Titular: " + titular.getNombre() +
                " | Saldo: " + saldo +
                " | Fecha apertura: " + fechaApertura +
                " | Estado: " + estado);
    }


    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public Usuario getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public Estado getEstado() {
        return estado;
    }
}

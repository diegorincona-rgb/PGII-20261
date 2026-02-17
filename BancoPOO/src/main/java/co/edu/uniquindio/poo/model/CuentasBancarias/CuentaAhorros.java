package co.edu.uniquindio.poo.model.CuentasBancarias;

import co.edu.uniquindio.poo.model.Usuario;

import java.time.LocalDate;

public class CuentaAhorros extends Cuenta {

    private static final double SALDO_MINIMO = 100000.0;
    private static final double TASA_INTERES_ANUAL = 0.036;


    public CuentaAhorros(String numeroCuenta, Usuario titular, double saldo, LocalDate fechaApertura, Estado estado) {
        super(numeroCuenta, titular, saldo, fechaApertura, estado);
    }

    @Override
    public void depositar(double cantidad) {
        if (estado == Estado.ACTIVA && cantidad > 0) {
            this.saldo += cantidad;
            System.out.println("Depósito exitoso. Nuevo saldo: " + this.saldo);
        } else {
            System.out.println("No se puede depositar. La cuenta no está activa o la cantidad no es válida.");
        }
    }


    @Override
    public void retirar(double cantidad) {
        if (estado == Estado.ACTIVA && cantidad > 0) {
            if ((this.saldo - cantidad) >= SALDO_MINIMO) {
                this.saldo -= cantidad;
                System.out.println("Retiro exitoso. Nuevo saldo: " + this.saldo);
            } else {
                System.out.println("Retiro no permitido. El saldo no puede ser inferior a " + SALDO_MINIMO + ".");
                bloquear();
            }
        } else {
            System.out.println("No se puede retirar. La cuenta no está activa o la cantidad no es válida.");
        }
    }

    public void aplicarInteresMensual() {
        if (estado == Estado.ACTIVA) {
            double tasaMensual = TASA_INTERES_ANUAL / 12.0;
            double interesGanado = this.saldo * tasaMensual;
            this.saldo += interesGanado;
            System.out.println("Interés mensual aplicado: " + interesGanado + ". Nuevo saldo: " + this.saldo);
        }
    }
}

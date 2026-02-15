package co.edu.uniquindio.poo.model.CuentasBancarias;
import co.edu.uniquindio.poo.model.Usuario;
import java.time.LocalDate;


public class CuentaCorriente extends Cuenta {
    private static final double SOBREGIRO_MAXIMO = 500000.0;
    private double sobregiroActual;

    public CuentaCorriente(String numeroCuenta, Usuario titular, double saldo, LocalDate fechaApertura, Estado estado) {
        super(numeroCuenta, titular, saldo, fechaApertura, estado);
        this.sobregiroActual = 0.0;
    }

    @Override
    public void depositar(double cantidad) {
        if (estado == Estado.ACTIVA && cantidad > 0) {
            if (sobregiroActual > 0) {
                double restante = cantidad - sobregiroActual;
                if (restante >= 0) {
                    this.saldo += restante;
                    sobregiroActual = 0;
                } else {
                    sobregiroActual -= cantidad;
                }
            } else {
                this.saldo += cantidad;
            }
            System.out.println("Depósito exitoso. Nuevo saldo: " + this.saldo + " (Sobregiro actual: " + this.sobregiroActual + ")");
        } else {
            System.out.println("No se puede depositar. La cuenta no está activa o la cantidad no es válida.");
        }
    }

    @Override
    public void retirar(double cantidad) {
        if (estado == Estado.ACTIVA && cantidad > 0) {
            if (this.saldo >= cantidad) {
                this.saldo -= cantidad;
                System.out.println("Retiro exitoso. Nuevo saldo: " + this.saldo);
            } else {
                double deficit = cantidad - this.saldo;
                if ((this.sobregiroActual + deficit) <= SOBREGIRO_MAXIMO) {
                    this.saldo = 0;
                    this.sobregiroActual += deficit;
                    System.out.println("Retiro exitoso con sobregiro. Saldo: " + this.saldo + " (Sobregiro actual: " + this.sobregiroActual + ")");
                } else {
                    System.out.println("Retiro no permitido. Excede el límite de sobregiro (" + SOBREGIRO_MAXIMO + ").");
                }
            }
        } else {

}

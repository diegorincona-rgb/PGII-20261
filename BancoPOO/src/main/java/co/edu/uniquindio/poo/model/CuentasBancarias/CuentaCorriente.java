package co.edu.uniquindio.poo.model.CuentasBancarias;
import co.edu.uniquindio.poo.model.Usuario;
import java.time.LocalDate;


public class CuentaCorriente extends Cuenta {
    private static final double SOBREGIRO_MAXIMO = 500000.0;
    private static final double COMISION_MENSUAL = 15000.0;
    private static final double TASA_INTERES_SOBREGIRO_MENSUAL = 0.02;

    private double sobregiroActual;

    public CuentaCorriente(String numeroCuenta, Usuario titular, double saldo, LocalDate fechaApertura, Estado estado) {
        super(numeroCuenta, titular, saldo, fechaApertura, estado);
        this.sobregiroActual = 0.0;
    }

    @Override
    public void depositar(double cantidad) {
        if (estado == Estado.ACTIVA && cantidad > 0) {
            if (sobregiroActual > 0) {
                double montoParaPagarSobregiro = Math.min(cantidad, sobregiroActual);
                sobregiroActual -= montoParaPagarSobregiro;
                double restante = cantidad - montoParaPagarSobregiro;
                if (restante > 0) {
                    this.saldo += restante;
                }
            } else {
                this.saldo += cantidad;
            }
            System.out.println("Depósito exitoso. Nuevo saldo: " + this.saldo + " (Sobregiro actual: " +
                    this.sobregiroActual + ")");
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
                if (sobregiroActual + deficit <= SOBREGIRO_MAXIMO) {
                    this.saldo = 0;
                    this.sobregiroActual += deficit;
                    System.out.println("Retiro exitoso con sobregiro. Saldo: " + this.saldo + " (Sobregiro actual: " +
                            this.sobregiroActual + ")");
                } else {
                    System.out.println("Retiro no permitido. Excede el límite de sobregiro (" + SOBREGIRO_MAXIMO + ").");
                }
            }
        } else {
            System.out.println("No se puede retirar. La cuenta no está activa o la cantidad no es válida.");
        }
    }

    public void cobrarComisionMensual() {
        if (estado == Estado.ACTIVA) {
            System.out.println("Aplicando comisión mensual de: " + COMISION_MENSUAL);
            retirar(COMISION_MENSUAL);
        } else {
            System.out.println("No se puede cobrar comisión, la cuenta no está activa.");
        }
    }

    public void aplicarInteresSobregiro() {
        if (estado == Estado.ACTIVA && sobregiroActual > 0) {
            double interes = sobregiroActual * TASA_INTERES_SOBREGIRO_MENSUAL;
            double nuevoSobregiroTotal = sobregiroActual + interes;
            if (nuevoSobregiroTotal <= SOBREGIRO_MAXIMO) {
                sobregiroActual = nuevoSobregiroTotal;
                System.out.println("Se aplicó interés por sobregiro de: " + interes + ". Sobregiro total: "
                        + sobregiroActual);
            } else {
                System.out.println("No se pudo aplicar el interés por sobregiro, excedería el límite máximo.");
            }
        }
    }
}
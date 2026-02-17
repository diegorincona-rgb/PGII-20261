package co.edu.uniquindio.poo.model.CuentasBancarias;

public class CuentaNomina extends  Cuenta {
    private static final double SALDO_MINIMO_NOMINA = 0.0;

    public CuentaNomina(String numeroCuenta, co.edu.uniquindio.poo.model.Usuario titular, double saldo, java.time.LocalDate fechaApertura, Estado estado) {
        super(numeroCuenta, titular, saldo, fechaApertura, estado);
    }

    @Override
    public void depositar(double cantidad) {
        if (estado == Estado.ACTIVA && cantidad > 0) {
            this.saldo += cantidad;
            System.out.println("Depósito de nómina exitoso. Nuevo saldo: " + this.saldo);
        } else {
            System.out.println("No se puede depositar. La cuenta no está activa o la cantidad no es válida.");
        }
    }

    @Override
    public void retirar(double cantidad) {
        if (estado == Estado.ACTIVA && cantidad > 0) {
            if ((this.saldo - cantidad) >= SALDO_MINIMO_NOMINA) {
                this.saldo -= cantidad;
                System.out.println("Retiro exitoso. Nuevo saldo: " + this.saldo);
            } else {
                System.out.println("Retiro no permitido. El saldo no puede ser inferior a " + SALDO_MINIMO_NOMINA + ".");
            }
        } else {
            System.out.println("No se puede retirar. La cuenta no está activa o la cantidad no es válida.");
        }
    }

}

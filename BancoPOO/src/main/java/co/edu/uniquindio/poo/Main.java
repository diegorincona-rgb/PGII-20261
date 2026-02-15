package co.edu.uniquindio.poo;


import co.edu.uniquindio.poo.model.Banco;
import co.edu.uniquindio.poo.model.CuentasBancarias.CuentaAhorros;
import co.edu.uniquindio.poo.model.CuentasBancarias.Estado;
import co.edu.uniquindio.poo.model.Usuario;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("BANCOUNI", 125478, "Carrera 19 numero 40 - 25 Centro",
                318789456);

        Usuario titular = new Usuario("DIEGO RINCON", "1094789450", 318862555,
                "calle 50 Puerto Espejo","1992/11/12");

        CuentaAhorros cuentaAhorros = new CuentaAhorros("1235896478", titular, 150000.0,
                LocalDate.of(2026, 1, 21), Estado.ACTIVA);

        cuentaAhorros.mostrarInformacion();
        cuentaAhorros.retirar(60000.0);
        cuentaAhorros.mostrarInformacion();
    }
}
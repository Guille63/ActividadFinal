package org.example.actividadfinal.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de test para la clase Dispositivo
 */
public class DispositivoTest {

    /**
     * Test para comprobar que se añade un dispositivo a la lista de dispositivos
     */
    @Test
    void testCompareFechaFecha1MayorQueFecha2() {
        Dispositivo dispositivo1 = new Dispositivo();
        dispositivo1.setFechaCompra(LocalDate.of(2023, 1, 1));

        Dispositivo dispositivo2 = new Dispositivo();
        dispositivo2.setFechaCompra(LocalDate.of(2022, 1, 1));

        int resultAsc = dispositivo1.compareFecha(dispositivo2, true);
        assertTrue(resultAsc > 0, "Resultado esperado > 0 para comparación en orden ascendente cuando fechaCompra de dispositivo1 es posterior a fechaCompra de dispositivo2");

        int resultDesc = dispositivo1.compareFecha(dispositivo2, false);
        assertTrue(resultDesc < 0, "Resultado esperado < 0 para comparación en orden descendente cuando fechaCompra de dispositivo1 es posterior a fechaCompra de dispositivo2");
    }

    /**
     * Test para comprobar que se añade un dispositivo a la lista de dispositivos
     */
    @Test
    void testCompareFechaFecha1MenorQueFecha2() {
        Dispositivo dispositivo1 = new Dispositivo();
        dispositivo1.setFechaCompra(LocalDate.of(2022, 1, 1));

        Dispositivo dispositivo2 = new Dispositivo();
        dispositivo2.setFechaCompra(LocalDate.of(2023, 1, 1));

        int resultAsc = dispositivo1.compareFecha(dispositivo2, true);
        assertTrue(resultAsc < 0, "Resultado esperado < 0 para comparación en orden ascendente cuando fechaCompra de dispositivo1 es anterior a fechaCompra de dispositivo2");

        int resultDesc = dispositivo1.compareFecha(dispositivo2, false);
        assertTrue(resultDesc > 0, "Resultado esperado > 0 para comparación en orden descendente cuando fechaCompra de dispositivo1 es anterior a fechaCompra de dispositivo2");
    }

    /**
     * Test para comprobar que se añade un dispositivo a la lista de dispositivos
     */
    @Test
    void testCompareFechasIguales() {
        Dispositivo dispositivo1 = new Dispositivo();
        dispositivo1.setFechaCompra(LocalDate.of(2022, 1, 1));

        Dispositivo dispositivo2 = new Dispositivo();
        dispositivo2.setFechaCompra(LocalDate.of(2022, 1, 1));

        int resultAsc = dispositivo1.compareFecha(dispositivo2, true);
        assertEquals(0, resultAsc, "Resultado esperado = 0 para comparación en orden ascendente cuando fechaCompra de dispositivo1 es igual a fechaCompra de dispositivo2");

        int resultDesc = dispositivo1.compareFecha(dispositivo2, false);
        assertEquals(0, resultDesc, "Resultado esperado = 0 para comparación en orden descendente cuando fechaCompra de dispositivo1 es igual a fechaCompra de dispositivo2");
    }
}
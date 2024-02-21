package org.example.actividadfinal.models;

import org.example.actividadfinal.TipoAtributo;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de test para la clase Inventario
 */
public class InventarioTest {

    /**
     * Test para comprobar que se añade un dispositivo a la lista de dispositivos
     */
    @Test
    void altaDispositivoSiElDispositivoExiste() {
        Dispositivo dispositivo = new Dispositivo("1", LocalDate.parse("2021-01-01"), 100, TipoAtributo.Ordenador, "marca", "modelo");
        List<Dispositivo> dispositivos = new ArrayList<>();
        dispositivos.add(dispositivo);
        Inventario inventario = new Inventario(dispositivos);

        Dispositivo dispositivoNuevo = new Dispositivo("1", LocalDate.parse("2021-01-01"), 100, TipoAtributo.Ordenador, "marca", "modelo");
        List<Dispositivo> result = inventario.altaDispositivo(dispositivoNuevo);

        assertEquals(1, result.size(), "Tamaño esperado de la lista de dispositivos = 1 después de añadir un nuevo dispositivo");
        assertTrue(result.contains(dispositivoNuevo), "Se espera que la lista de dispositivos contenga el dispositivo añadido");
    }

    /**
     * Test para comprobar que se añade un dispositivo a la lista de dispositivos
     */
    @Test
    void altaDispositivoDeUnNuevoDispositivo() {
        Dispositivo dispositivo = new Dispositivo();
        List<Dispositivo> dispositivos = new ArrayList<>();
        Inventario inventario = new Inventario(dispositivos);

        List<Dispositivo> result = inventario.altaDispositivo(dispositivo);

        assertEquals(1, result.size(), "Tamaño esperado de la lista de dispositivos = 1 después de añadir un nuevo dispositivo");
        assertTrue(result.contains(dispositivo), "Se espera que la lista de dispositivos contenga el dispositivo añadido");
    }
}
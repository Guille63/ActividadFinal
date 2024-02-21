package org.example.actividadfinal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.actividadfinal.models.Dispositivo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javax.swing.text.html.ListView;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InventarioControllerTest extends ApplicationTest {

    private InventarioController inventarioController;
    private Dispositivo dispositivo1;
    private Dispositivo dispositivo2;

    @BeforeEach
    void setUp() {
        inventarioController = new InventarioController();
        dispositivo1 = new Dispositivo();
        dispositivo1.setFechaCompra(LocalDate.of(2021, 1, 1));
        dispositivo2 = new Dispositivo();
        dispositivo2.setFechaCompra(LocalDate.of(2021, 1, 2));
    }

    @Test
    void ordenarPorFechaConListaVacia() {
        ObservableList<Dispositivo> dispositivos = FXCollections.observableArrayList();
        inventarioController.lvDispositivos.setItems(dispositivos);
        inventarioController.ordenarPorFecha(null);
        assertTrue(dispositivos.isEmpty());
    }

    @Test
    void ordenarPorFechaEnOrdenAscendente() {
        ObservableList<Dispositivo> dispositivos = FXCollections.observableArrayList(dispositivo1, dispositivo2);
        inventarioController.lvDispositivos.setItems(dispositivos);
        inventarioController.ordenarPorFecha(null);
        assertEquals(dispositivo1, dispositivos.get(0));
        assertEquals(dispositivo2, dispositivos.get(1));
    }

    @Test
    void ordenarPorFechaEnOrdenDescendente() {
        ObservableList<Dispositivo> dispositivos = FXCollections.observableArrayList(dispositivo1, dispositivo2);
        inventarioController.lvDispositivos.setItems(dispositivos);
        inventarioController.ordenarPorFecha(null);
        assertEquals(dispositivo2, dispositivos.get(0));
        assertEquals(dispositivo1, dispositivos.get(1));
    }


}
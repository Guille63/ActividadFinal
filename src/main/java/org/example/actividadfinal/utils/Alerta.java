package org.example.actividadfinal.utils;

import javafx.scene.control.Alert;

public class Alerta {
    public static void mostrarAlerta(String titulo, String header, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

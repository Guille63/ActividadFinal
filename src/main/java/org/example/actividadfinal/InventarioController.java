package org.example.actividadfinal;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.actividadfinal.models.Dispositivo;
import org.example.actividadfinal.utils.Alerta;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Clase que controla la ventana de inventario
 *
 * @author Guillem Ruiz
 */
public class InventarioController {

    @FXML
    private Button bt_AddEdit;

    @FXML
    private Button bt_Ordenar;

    @FXML
    private Label labelFecha;

    @FXML
    private Label labelMarca;

    @FXML
    private Label labelModelo;

    @FXML
    private Label labelPrecio;

    @FXML
    private Label labelTipoDispositivo;

    @FXML
    ListView<Dispositivo> lvDispositivos;

    @FXML
    private AnchorPane anchorPane;
    boolean ordenadoAscendente = false;

    /**
     * Constructor de la clase
     */
    public InventarioController() {
        lvDispositivos = new ListView<>();
    }

    /**
     * Método que se ejecuta cuando se carga la ventana
     */
    @FXML
    void initialize() {
        bt_Ordenar.setText("Ordenar asc");
        anchorPane.setOnMouseClicked(event -> {
            limpiar();
        });
    }

    /**
     * Método que se ejecuta cuando el usuario hace click en un dispositivo de la lista
     * Muestra los datos del dispositivo seleccionado en las etiquetas
     *
     * @param event
     */
    @FXML
    void onDispositivoClicked(MouseEvent event) {
        Dispositivo dispositivo = lvDispositivos.getSelectionModel().getSelectedItem();
        labelFecha.setText(dispositivo.getFechaCompra().toString());
        labelMarca.setText(dispositivo.getMarca());
        labelModelo.setText(dispositivo.getModelo());
        labelPrecio.setText(String.valueOf(dispositivo.getPrecio()));
        labelTipoDispositivo.setText(dispositivo.getTipoAtributo().toString());
    }

    /**
     * Método que se ejecuta cuando el usuario hace click en el botón de imprimir
     * Imprime el inventario en un fichero de texto
     *
     * @param event
     */
    @FXML
    void onImprimirButtonClick(ActionEvent event) {

        if (!lvDispositivos.getItems().isEmpty()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("files/inventario.txt"))) {
                for (Dispositivo dispositivo : lvDispositivos.getItems()) {
                    bw.write(dispositivo.toString());
                    bw.newLine();
                }
                Alerta.mostrarAlerta("Inventario impreso", null, "El inventario se ha impreso correctamente", Alert.AlertType.INFORMATION);

            } catch (Exception e) {
                Alerta.mostrarAlerta("Error", null, "Ha ocurrido un error al imprimir el inventario", Alert.AlertType.ERROR);
            }
        } else {
            Alerta.mostrarAlerta("Inventario vacío", null, "No hay dispositivos en el inventario", Alert.AlertType.WARNING);
        }
    }

    /**
     * Método que se ejecuta cuando el usuario hace click en el botón add/edit
     * Abre la ventana de alta y modificación de dispositivos
     *
     * @param event
     */
    @FXML
    void ontAddEditClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dispositivo-view.fxml"));
            Parent root = fxmlLoader.load();

            DispositivoController dispositivoController = fxmlLoader.getController();
            dispositivoController.setInventarioController(this);
            if (lvDispositivos.getSelectionModel().getSelectedItem() != null) {
                dispositivoController.setDispositivo(lvDispositivos.getSelectionModel().getSelectedItem());
            } else {
                dispositivoController.setDispositivo(new Dispositivo());
            }

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que añade un dispositivo a la lista de dispositivos
     *
     * @param dispositivo
     */
    public void addDispositivo(Dispositivo dispositivo) {
        lvDispositivos.getItems().add(dispositivo);
    }


    /**
     * Método que limpia los campos de texto
     */
    public void limpiar() {
        lvDispositivos.getSelectionModel().clearSelection();
        labelFecha.setText("");
        labelMarca.setText("");
        labelModelo.setText("");
        labelPrecio.setText("");
        labelTipoDispositivo.setText("");

    }

    /**
     * Metodo que ordena la lista de dispositivos por fecha de compra de forma ascendente o descendente
     *
     * @param event
     */
    @FXML
    void ordenarPorFecha(ActionEvent event) {
        if (lvDispositivos.getItems().isEmpty()) {
            Alerta.mostrarAlerta("Inventario vacío", null, "No hay dispositivos en el inventario", Alert.AlertType.WARNING);
        } else {
            if (bt_Ordenar.getText().equals("Ordenar asc")) {
                ordenadoAscendente = true;
                bt_Ordenar.setText("Ordenar desc");
            } else {
                bt_Ordenar.setText("Ordenar asc");
                ordenadoAscendente = false;
            }
            lvDispositivos.getItems().sort((d1, d2) -> d1.compareFecha(d2, ordenadoAscendente));
        }
    }

    /**
     * Método que devuelve la lista de dispositivos
     *
     * @return
     */
    public ObservableList<Dispositivo> getListaDispositivos() {
        return lvDispositivos.getItems();
    }

    /**
     * Método que devuelve el dispositivo seleccionado
     *
     * @return
     */
    public Dispositivo getDispositivoSeleccionado() {
        return lvDispositivos.getSelectionModel().getSelectedItem();
    }
}

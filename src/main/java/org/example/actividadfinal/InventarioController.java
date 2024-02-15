package org.example.actividadfinal;

import javafx.application.Application;
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
    private ListView<Dispositivo> lvDispositivos;

    @FXML
    private AnchorPane anchorPane;

    public InventarioController() {

    }

    @FXML
    void initialize() {
        anchorPane.setOnMouseClicked(event -> {
            limpiar();
        });
    }

    @FXML
    void onDispositivoClicked(MouseEvent event) {
        Dispositivo dispositivo = lvDispositivos.getSelectionModel().getSelectedItem();
        labelFecha.setText(dispositivo.getFechaCompra().toString());
        labelMarca.setText(dispositivo.getMarca());
        labelModelo.setText(dispositivo.getModelo());
        labelPrecio.setText(String.valueOf(dispositivo.getPrecio()));
        labelTipoDispositivo.setText(dispositivo.getTipoAtributo().toString());
    }

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

    @FXML
    void onOrdenarButtonClick(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Ordenar");
        dialog.setHeaderText("Ordenar por:");
        dialog.setContentText("1: Fecha\n\n2: Precio\n\n3: Marca");
        dialog.showAndWait().ifPresent(tipoOrdenacion -> {
            if (tipoOrdenacion.equals("1") || tipoOrdenacion.equals("2") || tipoOrdenacion.equals("3")) {
                ordenarPor(Integer.parseInt(tipoOrdenacion));
            } else {
                Alerta.mostrarAlerta("Error", null, "El valor introducido no es válido", Alert.AlertType.ERROR);
            }
        });
    }

    public void ordenarPor(int tipoOrdenacion) {
        if (lvDispositivos.getItems().isEmpty()) {
            Alerta.mostrarAlerta("Inventario vacío", null, "No hay dispositivos en el inventario", Alert.AlertType.WARNING);
        } else {
            if (tipoOrdenacion == 1) {
                lvDispositivos.getItems().sort(Dispositivo::compareFecha);
            } else if (tipoOrdenacion == 2) {
                lvDispositivos.getItems().sort(Dispositivo::comparePrecio);
            } else if (tipoOrdenacion == 3) {
                lvDispositivos.getItems().sort(Dispositivo::compareMarca);
            }
        }
    }

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

    public void addDispositivo(Dispositivo dispositivo) {
        lvDispositivos.getItems().add(dispositivo);
    }

    public void updateDispositivo(Dispositivo dispositivo) {
        Dispositivo dispositivo1 = lvDispositivos.getSelectionModel().getSelectedItem();
        dispositivo1.setMarca(dispositivo.getMarca());
        dispositivo1.setModelo(dispositivo.getModelo());
        dispositivo1.setPrecio(dispositivo.getPrecio());
        dispositivo1.setFechaCompra(dispositivo.getFechaCompra());
        dispositivo1.setTipoAtributo(dispositivo.getTipoAtributo());

    }

    public void limpiar() {
        lvDispositivos.getSelectionModel().clearSelection();
        labelFecha.setText("");
        labelMarca.setText("");
        labelModelo.setText("");
        labelPrecio.setText("");
        labelTipoDispositivo.setText("");

    }


    public ObservableList<Dispositivo> getListaDispositivos() {
        return lvDispositivos.getItems();
    }

    public Dispositivo getDispositivoSeleccionado() {
        return lvDispositivos.getSelectionModel().getSelectedItem();
    }
}

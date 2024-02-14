package org.example.actividadfinal;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.actividadfinal.models.Dispositivo;

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

    public InventarioController() {

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

    }

    @FXML
    void onOrdenarButtonClick(ActionEvent event) {

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
        Dispositivo dispositivo1 =  lvDispositivos.getSelectionModel().getSelectedItem();
        dispositivo1.setMarca(dispositivo.getMarca());
        dispositivo1.setModelo(dispositivo.getModelo());
        dispositivo1.setPrecio(dispositivo.getPrecio());
        dispositivo1.setFechaCompra(dispositivo.getFechaCompra());
        dispositivo1.setTipoAtributo(dispositivo.getTipoAtributo());

    }


    public ObservableList<Dispositivo> getListaDispositivos() {
        return lvDispositivos.getItems();
    }

    public Dispositivo getDispositivoSeleccionado() {
        return lvDispositivos.getSelectionModel().getSelectedItem();
    }
}

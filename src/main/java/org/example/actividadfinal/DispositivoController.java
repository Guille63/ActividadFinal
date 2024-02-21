package org.example.actividadfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.actividadfinal.models.Dispositivo;

/**
 * Clase que controla la ventana de alta y modificación de dispositivos
 */
public class DispositivoController {

    @FXML
    private Button bt_Alta;

    @FXML
    private ComboBox<TipoAtributo> cbTipoDispositivo;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField tfMarca;

    @FXML
    private TextField tfModelo;

    @FXML
    private TextField tfPrecio;

    private InventarioController inventarioController;

    public DispositivoController() {

    }

    /**
     * Método que se ejecuta cuando se carga la ventana
     * Se encarga de cargar los valores del ComboBox con los tipos de dispositivos
     */
    @FXML
    public void initialize() {
        cbTipoDispositivo.getItems().setAll(TipoAtributo.values());
    }

    /**
     * Método que se ejecuta cuando el usuario hace click en el botón de alta o modificación
     * si el dispositivo ya existe en la lista de dispositivos, se actualiza, si no, se añade.
     * @param event
     */
    @FXML
    void onAltaModificacionClick(ActionEvent event) {
        // Verificar si los campos están vacíos
        if (tfMarca.getText() == null || tfMarca.getText().isEmpty() ||
                tfModelo.getText() == null || tfModelo.getText().isEmpty() ||
                tfPrecio.getText() == null || tfPrecio.getText().isEmpty() ||
                datePicker.getValue() == null || cbTipoDispositivo.getValue() == null) {

            // Mostrar una alerta al usuario
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos vacíos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, rellena todos los campos antes de continuar.");
            alert.showAndWait();

        } else {
            Dispositivo dispositivo = getDispositivo();

            if (!inventarioController.getListaDispositivos().contains(dispositivo)) {
                inventarioController.addDispositivo(dispositivo);
            } else {
                inventarioController.updateDispositivo(dispositivo);
                // Refresh the list view after updating a device
                inventarioController.getListaDispositivos().set(inventarioController.getListaDispositivos().indexOf(dispositivo), dispositivo);
            }

            bt_Alta.getScene().getWindow().hide();
        }


    }

    /**
     * Método que obtiene los valores de los campos de texto y los almacena en un objeto Dispositivo
     * @return Dispositivo
     */
    private Dispositivo getDispositivo() {
        Dispositivo dispositivo = inventarioController.getDispositivoSeleccionado();
        if (dispositivo == null) {
            dispositivo = new Dispositivo();
            dispositivo.setId(String.valueOf(inventarioController.getListaDispositivos().size() + 1));
        }
        dispositivo.setMarca(tfMarca.getText());
        dispositivo.setModelo(tfModelo.getText());
        dispositivo.setPrecio(Integer.parseInt(tfPrecio.getText()));
        dispositivo.setFechaCompra(datePicker.getValue());
        dispositivo.setTipoAtributo(cbTipoDispositivo.getValue());
        if (dispositivo.getId() == null) {
            dispositivo.setId(String.valueOf(inventarioController.getListaDispositivos().size() + 1));
        }
        return dispositivo;
    }


    /**
     * Método que establece los valores de los campos de texto con los valores del dispositivo seleccionado
     * @param dispositivo
     */
    public void setDispositivo(Dispositivo dispositivo) {
        tfMarca.setText(dispositivo.getMarca());
        tfModelo.setText(dispositivo.getModelo());
        tfPrecio.setText(String.valueOf(dispositivo.getPrecio()));
        datePicker.setValue(dispositivo.getFechaCompra());
        cbTipoDispositivo.setValue(dispositivo.getTipoAtributo());
    }

    /**
     * Método que establece el controlador de inventario
     * @param inventarioController
     */
    public void setInventarioController(InventarioController inventarioController) {
        this.inventarioController = inventarioController;
    }


}

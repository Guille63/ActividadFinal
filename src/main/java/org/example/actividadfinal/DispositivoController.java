package org.example.actividadfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.example.actividadfinal.models.Dispositivo;

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

    @FXML
    public void initialize() {
        cbTipoDispositivo.getItems().setAll(TipoAtributo.values());
    }

    @FXML
    void onAltaModificacionClick(ActionEvent event) {
        //Se recogen los datos de los campos y se crea un nuevo dispositivo

        Dispositivo dispositivo;
        if(tfMarca.getText().isEmpty() || tfModelo.getText().isEmpty() || tfPrecio.getText().isEmpty() || datePicker.getValue() == null || cbTipoDispositivo.getValue() == null) {
            dispositivo = new Dispositivo();
            dispositivo.setMarca(tfMarca.getText());
            dispositivo.setModelo(tfModelo.getText());
            dispositivo.setPrecio(Integer.parseInt(tfPrecio.getText()));
            dispositivo.setFechaCompra(datePicker.getValue());
            dispositivo.setTipoAtributo(cbTipoDispositivo.getValue());
            if(dispositivo.getId() == null) {
                dispositivo.setId(String.valueOf(inventarioController.getListaDispositivos().size() + 1));
            }
        } else {
            //actualizar dispositivo que se ha seleccionado
            dispositivo = inventarioController.getDispositivoSeleccionado();
            dispositivo.setMarca(tfMarca.getText());
            dispositivo.setModelo(tfModelo.getText());
            dispositivo.setPrecio(Integer.parseInt(tfPrecio.getText()));
            dispositivo.setFechaCompra(datePicker.getValue());
            dispositivo.setTipoAtributo(cbTipoDispositivo.getValue());
        }




        if(!inventarioController.getListaDispositivos().contains(dispositivo)) {
            inventarioController.addDispositivo(dispositivo);
        } else{
            inventarioController.updateDispositivo(dispositivo);
        }

        //se cierra la ventana
        bt_Alta.getScene().getWindow().hide();
    }

    public void setDispositivo(Dispositivo dispositivo) {
        tfMarca.setText(dispositivo.getMarca());
        tfModelo.setText(dispositivo.getModelo());
        tfPrecio.setText(String.valueOf(dispositivo.getPrecio()));
        datePicker.setValue(dispositivo.getFechaCompra());
        cbTipoDispositivo.setValue(dispositivo.getTipoAtributo());
    }

    public void setInventarioController(InventarioController inventarioController) {
        this.inventarioController = inventarioController;
    }




}

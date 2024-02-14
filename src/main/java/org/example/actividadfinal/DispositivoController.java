package org.example.actividadfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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

    @FXML
    void onAltaModificacionClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        cbTipoDispositivo.getItems().setAll(TipoAtributo.values());
    }

}
